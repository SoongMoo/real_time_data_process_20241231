package boardSpringProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardSpringProject.domain.BoardDTO;
import boardSpringProject.repository.BoardDAO;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class BoardListService {
	@Autowired
	BoardDAO boardDAO;
	public void execute(HttpServletRequest request) {
		List<BoardDTO> list = boardDAO.boardSelectAll();
		request.setAttribute("list", list);
	}
}



