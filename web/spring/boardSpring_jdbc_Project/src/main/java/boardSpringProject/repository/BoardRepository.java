package boardSpringProject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import boardSpringProject.command.BoardCommand;
import boardSpringProject.domain.BoardDTO;

@Repository
public class BoardRepository {
	String sql;
	@Autowired
	JdbcTemplate jdbcTemplate ;
	public int boardInsert(BoardDTO dto) {
		String autoNum = " select nvl(max(board_num),0) + 1 from board ";
		sql = " insert into board (board_num, board_writer, board_subject , board_content) "
			+ "             values( (" + autoNum + "), ?,?,?)";
		return jdbcTemplate.update(sql,dto.getBoardWriter(), dto.getBoardSubject()
				                  , dto.getBoardContent());
	}
	// select
	public List<BoardDTO> boardSelectAll(){
		List<BoardDTO> list = null;
		sql = " select board_num, board_writer, board_subject, board_content"
			+ " from board";
		/// list : query
		list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		return list;
	}
	public BoardDTO boardSelectOne(String boardNum) {
		BoardDTO dto = null;
		sql = " select board_num, board_writer, board_subject, board_content"
			+ " from board"
			+ " where board_num = ? "  ;
		/// dto : queryForObject
		dto = jdbcTemplate.queryForObject(sql, 
				new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class),
				boardNum);
		return dto;
	}
	public int boardUpdate(BoardDTO dto) {
		sql = " update board "
			+ " set board_writer = ?"
			+ "    ,board_subject = ? "
			+ "    ,board_content = ? "
			+ " where board_num = ?";
		return jdbcTemplate.update(sql,dto.getBoardWriter()
									  ,dto.getBoardSubject()
									  ,dto.getBoardContent()
									  ,dto.getBoardNum());
	}
	public int boardDelete(String boardNum) {
		sql = " delete from board "
			+ " where board_num = ? ";
		return jdbcTemplate.update(sql,boardNum);
	}
	
	
	
	
	
	
	
	
}
