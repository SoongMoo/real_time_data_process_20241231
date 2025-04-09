package boardSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardSpringProject.domain.BoardDTO;
import boardSpringProject.repository.BoardDAO;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class BoardWriteService {
	@Autowired
	BoardDAO boardDAO;
	public void execute(HttpServletRequest request) {
		String boardWriter = request.getParameter("boardWriter");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(boardContent);
		dto.setBoardSubject(boardSubject);
		dto.setBoardWriter(boardWriter);
		//BoardDAO boardDAO = new BoardDAO();
		boardDAO.boardInsert(dto);
	}
}

