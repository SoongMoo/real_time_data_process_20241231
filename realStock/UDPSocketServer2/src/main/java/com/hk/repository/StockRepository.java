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
			sql = " insert into stock (trading_date, trading_hours, symbol, price , volume, cumulative_Volume) "
				+ "             values(sysdate, ?,?, ?,?,?)";
			jdbcTemplate.update(sql, stockData.getString("timestamp")
								   , stockData.getString("symbol")
								   , stockData.getInt("price")
								   , stockData.getInt("volume")
								   , stockData.getInt("cumulativeVolume"));
		} catch (Exception e) {
	        System.out.println("DB 저장 실패: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
}