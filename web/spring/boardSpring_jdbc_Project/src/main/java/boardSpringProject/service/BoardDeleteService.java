package boardSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardSpringProject.repository.BoardRepository;

@Service
public class BoardDeleteService {
	@Autowired
	BoardRepository boardRepository;
	public void execute(String boardNum) {
		boardRepository.boardDelete(boardNum);
	}
}
