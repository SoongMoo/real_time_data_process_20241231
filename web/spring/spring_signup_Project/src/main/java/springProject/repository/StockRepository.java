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
				+ "    TO_CHAR(trading_date, 'yyyy-MM-dd') AS trading_date, "
				+ "    rn AS max_rn, "
				+ "    symbol, "
				+ "    price, "
				+ "    volume, "
				+ "    cumulative_volume "
				+ "FROM ( "
				+ "    SELECT  "
				+ "        ROW_NUMBER() OVER ( "
				+ "            PARTITION BY TO_CHAR(trading_date, 'yyyy-MM-dd')  "
				+ "            ORDER BY trading_hours DESC  "
				+ "        ) AS rn, "
				+ "        trading_date, "
				+ "        symbol, "
				+ "        price, "
				+ "        volume, "
				+ "        cumulative_volume "
				+ "    FROM stock "
				+ "    WHERE TO_NUMBER(trading_hours) < 153100 "
				+ ") "
				+ "WHERE rn = 1 "
				+ "ORDER BY trading_date DESC ";
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
				+ "WHERE rn = 1";
		return jdbcTemplate.query(sql
				, new BeanPropertyRowMapper<StockA3>(StockA3.class));
	}
}
