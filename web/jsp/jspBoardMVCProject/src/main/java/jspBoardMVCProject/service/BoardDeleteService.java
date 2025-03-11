package jspBoardMVCProject.service;

import javax.servlet.http.HttpServletRequest;

import jspBoardMVCProject.model.BoardDAO;

public class BoardDeleteService {
	public void execute(HttpServletRequest request) {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		BoardDAO dao = new BoardDAO();
		dao.boardDelete(boardNum);
	}
}
