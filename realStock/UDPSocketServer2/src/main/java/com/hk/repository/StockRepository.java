package com.hk.repository;

import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StockRepository {
	String sql;
	private final JdbcTemplate jdbcTemplate;

    public StockRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	public void stockInsert(JSONObject stockData) {
		try {
			System.out.println("ssss");
			sql = " insert into stock (trading_hours, symbol, price , volume, cumulative_Volume) "
				+ "             values( ?,?, ?,?,?)";
			jdbcTemplate.update(sql, stockData.getString("timestamp")
								   , stockData.getString("symbol")
								   , stockData.getInt("price")
								   , stockData.getInt("volume")
								   , stockData.getInt("cumulativeVolume"));
		} catch (Exception e) {
	        System.out.println("DB 저장 실패: " + e.getMessage());
	        e.printStackTrace();
	    }
		
		/*
		System.out.println("records" +  stockData);
		String sql = "INSERT INTO stock (trading_hours, symbol, price, volume, cumulative_volume) VALUES (?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, stockData.getString("timestamp"));
            pstmt.setString(2, stockData.getString("symbol"));
            pstmt.setInt(3, stockData.getInt("price"));
            pstmt.setInt(4, stockData.getInt("volume"));
            pstmt.setInt(5, stockData.getInt("cumulativeVolume"));
            pstmt.executeUpdate();
            System.out.println("주식 정보 저장 성공");
        } catch (SQLException e) {
            System.out.println("DB 저장 실패: " + e.getMessage());
            e.printStackTrace();
        }
        */
	}
}