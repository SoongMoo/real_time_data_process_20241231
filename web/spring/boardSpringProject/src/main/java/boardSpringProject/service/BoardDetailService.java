package boardSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardSpringProject.domain.BoardDTO;
import boardSpringProject.repository.BoardDAO;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class BoardDetailService {
	@Autowired
	BoardDAO boardDAO;
	public void execute(HttpServletRequest request) {
		String boardNum = request.getParameter("boardNum");
		BoardDTO dto = boardDAO.boardSelectOne(boardNum);
		request.setAttribute("dto", dto);		
	}
}






