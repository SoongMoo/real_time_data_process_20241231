package boardSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardSpringProject.command.BoardCommand;
import boardSpringProject.domain.BoardDTO;
import boardSpringProject.repository.BoardRepository;

@Service
public class BoardWriteService {
	@Autowired 
	BoardRepository boardRepository;
	public void execute(BoardCommand boardCommand) {
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(boardCommand.getBoardContent());
		dto.setBoardSubject(boardCommand.getBoardSubject());
		dto.setBoardWriter(boardCommand.getBoardWriter());
		
		boardRepository.boardInsert(dto);
	}
}
