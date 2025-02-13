package boardTest.service;

import java.util.List;

import boardTest.model.BoardDAO;
import boardTest.model.BoardDTO;

public class BoardListService {
	public List<BoardDTO> execute() {
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.boardList();
		return list;
	}
}
