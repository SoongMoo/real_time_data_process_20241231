package jspBoardMVCProject.service;

import javax.servlet.http.HttpServletRequest;

import jspBoardMVCProject.model.BoardDAO;
import jspBoardMVCProject.model.BoardDTO;

public class BoardDetailService {
	public void execute(HttpServletRequest request) {
						/*Wrapper*/       	/* string */ 
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.boardSelectOne(boardNum);
		request.setAttribute("dto", dto);
	}
}
