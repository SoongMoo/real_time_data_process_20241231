<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  body, html {
    margin: 0;
    padding: 0;
    overflow: hidden; /* 필요시 */
  }

  #chartContainer {
    width: 800px;
    height: 400px;
    margin: 0 auto;
  }

  #myChart {
    width: 800px !important;
    height: 400px !important;
    background-color: white;
  }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels@2.2.0/dist/chartjs-plugin-datalabels.min.js"></script>
<script>
let chart;

function createChart(data) {
  const MAX_LENGTH = 23000;
  const ctx = document.getElementById('myChart').getContext('2d');

  if (chart) {
    chart.destroy();
  }

  // 커스텀 플러그인 선언 — 마지막 값을 그래프에 출력
const drawLastValuePlugin = {
  id: 'drawLastValue',
  afterDatasetsDraw(chart) {
    const ctx = chart.ctx;
    chart.data.datasets.forEach((dataset, i) => {
      const meta = chart.getDatasetMeta(i);
      const dataPoints = meta.data;

      // 마지막 유효 데이터 포인트 찾기
      for (let j = dataPoints.length - 1; j >= 0; j--) {
        const value = dataset.data[j];
        const point = dataPoints[j];
        if (value !== null && !isNaN(value) && point) {
          ctx.save();
          ctx.fillStyle = dataset.borderColor || 'black';
          ctx.font = 'bold 14px Arial';
          ctx.textAlign = 'left';
          ctx.textBaseline = 'middle';
          ctx.fillText(value, point.x + 10, point.y - 10);
          ctx.restore();
          break; // 마지막 유효 데이터만 출력
        }
      }
    });
  }
};

  // 원본 가격 데이터
  let prices = data.map(item => item.price);

  // 가격 데이터가 부족하면 null로 채워서 MAX_LENGTH 길이에 맞추기
  if (prices.length < MAX_LENGTH) {
    const padding = new Array(MAX_LENGTH - prices.length).fill(null);
    prices = prices.concat(padding);
  }

  // 라벨은 0에서 MAX_LENGTH까지 순차적으로 설정
  const labels = Array.from({ length: MAX_LENGTH }, (_, i) => i);

  // 유효한 가격만 필터링 후 최소, 최대값 설정
  const validPrices = prices.filter(p => p !== null && !isNaN(p));
  const priceMin = Math.min(...validPrices) - 1000;
  const priceMax = Math.max(...validPrices) + 1000;

  // 차트 생성
  chart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: labels,
      datasets: [{
        label: 'Price',
        data: prices,
        borderColor: 'rgba(255, 99, 132, 1)', // 선 색상
        borderWidth: 1,
        pointRadius: 0,  // 데이터 포인트 표시 안함
        fill: false, // 선 아래 색 채우지 않음
        tension: 0.1 // 선의 곡률
      }]
    },
    options: {
      animation: false,
      responsive: true,  // 차트 크기 조정
      maintainAspectRatio: false,  // 가로세로 비율 고정 안함
      scales: {
        x: {
          display: true,
          min: 0,
          max: MAX_LENGTH,
          ticks: {
            display: false,
            maxTicksLimit: 20
          }
        },
        y: {
          min: priceMin,
          max: priceMax,
          ticks: {
            stepSize: 10
          }
        }
      },
      plugins: {
        legend: { display: true }
      }
    },
    plugins: [drawLastValuePlugin]  // 플러그인 배열에 넣기
  });

  // 차트 렌더링 후 마지막 값 출력
  chart.render();
}
</script>



<script>
function fetchData() {
  $.ajax({
    url: "/stockCurrent",
    type: "GET",
    dataType: "json",
    success: function(result) {
	  console.log(result.length)
      createChart(result);
    },
    error: function(xhr, status, error) {
      console.error("데이터 요청 실패:", error);
    }
  });
}

function startInterval() {
    // 8시 30분부터 15시 30분까지 interval 시작
    const now = new Date();
    const startTime = new Date();
    startTime.setHours(8, 30, 0, 0);  // 8시 30분
    const endTime = new Date();
    endTime.setHours(15, 30, 0, 0);  // 15시 30분

    // 인터벌이 실행되는 시간대인지 체크
    if (now >= startTime && now <= endTime) {
        // 1초마다 fetchData 실행
        fetchData();  // 새로 고침시 최초 한번 실행
        return setInterval(fetchData, 1000);  // 1초마다 fetchData 실행
    } else {
        return null;
    }
}

function stopInterval(intervalId) {
    // 인터벌 멈추기
    clearInterval(intervalId);
}

function checkTimeAndStartInterval() {
    const now = new Date();
    const startTime = new Date();
    startTime.setHours(8, 30, 0, 0);  // 8시 30분
    const endTime = new Date();
    endTime.setHours(15, 30, 0, 0);  // 15시 30분

    // 인터벌을 시작할 시간인지 체크
    if (now >= startTime && now <= endTime) {
        return startInterval();  // interval 시작
    }
    return null;
}

// 페이지 로딩 시 첫 실행
window.onload = function() {
    // 새로고침 시 fetchData()를 한 번 실행
    fetchData();

    // 시간 체크 후 interval 시작/멈춤
    let intervalId = checkTimeAndStartInterval();

    // 시간을 계속 체크해서 인터벌을 관리
    setInterval(() => {
        const now = new Date();
        const startTime = new Date();
        startTime.setHours(8, 30, 0, 0);  // 8시 30분
        const endTime = new Date();
        endTime.setHours(15, 30, 0, 0);  // 15시 30분

        // 현재 시간이 인터벌 시작 시간 범위 안에 있는지 확인
        if (now >= startTime && now <= endTime && !intervalId) {
            intervalId = startInterval();
        } else if ((now < startTime || now > endTime) && intervalId) {
            stopInterval(intervalId);
            intervalId = null;
        }
    }, 60000 * 60);  // 매 1분마다 현재 시간을 체크
}
</script>
<script>
const today = new Date();

const yyyy = today.getFullYear();
const mm = String(today.getMonth() + 1).padStart(2, '0'); // 월은 0부터 시작하므로 +1
const dd = String(today.getDate()).padStart(2, '0');
function connect() {
	ws = new WebSocket("ws://localhost:5678");
	ws.onopen = onOpen;
	ws.onmessage = onMessage;
	ws.onclose = onClose;
}
function appendMessage(msg){
	$("#chatMessageArea").append(msg + "<br />");
	var chatAreaHeight = $("#chatArea").height();
	var maxScroll = $("#chatMessageArea").height() - chatAreaHeight
	$("#chatArea").scrollTop(maxScroll);
}
function onOpen(evt){
	appendMessage("연결되었습니다.");
}
function onMessage(evt){
	setInterval(updateStockData(evt), 2000);
}
function updateStockData(evt) {
	const msg = evt.data;
	const data = JSON.parse(msg);

	const now = new Date();
	const yyyy = now.getFullYear();
	const mm = String(now.getMonth() + 1).padStart(2, '0');
	const dd = String(now.getDate()).padStart(2, '0');
	const dateStr = yyyy + "-" + mm + "-" + dd;

	const newRow =
			"<td>" + dateStr + "</td>" +
			"<td>" + data.price + "</td>" +
			"<td>" + data.cumulativeVolume + "</td>";

	$("#stock").html(newRow);
}
function onClose(evt){
	appendMessage("연결을 끊었습니다.");
}
function send(){
	var msg = $("#message").val();
	ws.send(msg);
	$("#message").val("");
}
function  disconnect(){
	ws.close();
}
$(function(){
	connect();
});
</script>

 

</head>
<body>
<div id="chartContainer">
  <canvas id="myChart" width="800" height="400"></canvas>
</div>
<div class="container mt-4">
  <h5 class="mb-3">📈 주식 정보</h5>
  <table class="table table-bordered table-hover table-sm text-center align-middle">
    <thead class="table-light">
      <tr>
        <th>거래일</th>
        <th>종가</th>
        <th>누적거래량</th>
      </tr>
    </thead>
    <tbody>
     <tr id="stock"></tr>
      <c:forEach items="${list}" var="data">
        <tr>
          <td>${data.tradingDate}</td>
          <td>${data.price}</td>
          <td>${data.cumulativeVolume}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>