package springProject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import springProject.domain.StockA3;


@Repository
public class StockRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	String sql;
	public List<StockA3> stockSelect() { 
		sql = "SELECT  "
				+ "    TO_CHAR(s.TRADING_DATE, 'yyyy-MM-dd') AS TRADING_DATE,  "
				+ "    s.CUMULATIVE_VOLUME,  "
				+ "    s.PRICE,  "
				+ "    s.SYMBOL "
				+ "FROM  "
				+ "    stock s "
				+ "JOIN (  "
				+ "    SELECT  "
				+ "        TRUNC(TRADING_DATE) AS TRADING_DATE,  "
				+ "        MAX(CUMULATIVE_VOLUME) AS MAX_CUMULATIVE_VOLUME "
				+ "    FROM  "
				+ "        stock "
				+ "    WHERE  "
				+ "        TRUNC(TRADING_DATE) != TRUNC(SYSDATE) "
				+ "    GROUP BY  "
				+ "        TRUNC(TRADING_DATE)  "
				+ ") max_values  "
				+ "    ON TRUNC(s.TRADING_DATE) = max_values.TRADING_DATE  "
				+ "    AND s.CUMULATIVE_VOLUME = max_values.MAX_CUMULATIVE_VOLUME "
				+ "ORDER BY  "
				+ "    TRUNC(s.TRADING_DATE) DESC ";
		return jdbcTemplate.query(sql
				, new BeanPropertyRowMapper<StockA3>(StockA3.class));
	}
	
	public List<StockA3> stockCurrentSelect(){
		sql = " SELECT * "
				+ "FROM ( "
				+ "    SELECT s.*,  "
				+ "           ROW_NUMBER() OVER ( "
				+ "               PARTITION BY TO_CHAR(trading_date, 'yyyy-MM-dd'), trading_hours  "
				+ "               ORDER BY TO_CHAR(trading_date, 'yyyy-MM-dd') DESC, trading_hours DESC, ROWID DESC "
				+ "           ) AS rn "
				+ "    FROM stock s "
				+ "    WHERE TRUNC(trading_date) = TRUNC(SYSDATE) "
				+ ") "
				+ "WHERE rn = 1 ";
		return jdbcTemplate.query(sql
				, new BeanPropertyRowMapper<StockA3>(StockA3.class));
	}
}
