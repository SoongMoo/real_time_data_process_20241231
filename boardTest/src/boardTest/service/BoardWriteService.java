package boardTest.service;

import boardTest.model.BoardDAO;
import boardTest.model.BoardDTO;

public class BoardWriteService {
	public void execute(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		dao.boardInsert(dto);
	}
}
