package springProject.domain;

import java.util.Date;

import lombok.Data;

@Data
public class StockA3 {
	String tradingDate;
	String tradingHours;
	String symbol;
	int price;
	int volume;
	int cumulativeVolume;
}
