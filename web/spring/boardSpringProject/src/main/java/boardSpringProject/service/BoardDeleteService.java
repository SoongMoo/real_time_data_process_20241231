package boardSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardSpringProject.repository.BoardDAO;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class BoardDeleteService {
	@Autowired
	BoardDAO boardDAO;
	public void execute(HttpServletRequest request) {
		String boardNum = request.getParameter("boardNum");
		boardDAO.boardDelete(boardNum);
	}
}
