package boardSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardSpringProject.command.BoardCommand;
import boardSpringProject.domain.BoardDTO;
import boardSpringProject.repository.BoardDAO;

@Service
public class BoardUpdateService {
	@Autowired
	BoardDAO boardDAO;
	public void execute(BoardCommand boardCommand) {
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(boardCommand.getBoardContent());
		dto.setBoardNum(boardCommand.getBoardNum());
		dto.setBoardSubject(boardCommand.getBoardSubject());
		dto.setBoardWriter(boardCommand.getBoardWriter());
		boardDAO.boardUpdate(dto);
	}
}






