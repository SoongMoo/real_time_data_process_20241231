package boardSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardSpringProject.repository.BoardDAO;

@Service
public class BoardDeleteService {
	@Autowired
	BoardDAO boardDAO;
	public void execute(String boardNum) {
		boardDAO.boardDelete(boardNum);
	}
}
