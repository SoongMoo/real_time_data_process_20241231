package boardSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardSpringProject.domain.BoardDTO;
import boardSpringProject.repository.BoardDAO;

@Service
public class BoardInsertService {
	@Autowired
	BoardDAO boardDAO;
	public void execute(String boardWriter
			,String boardSubject
			,String boardContent) {
		BoardDTO dto = new BoardDTO(); 
		dto.setBoardContent(boardContent);
		dto.setBoardSubject(boardSubject);
		dto.setBoardWriter(boardWriter);
		
		boardDAO.boardInsert(dto);
	}
}
