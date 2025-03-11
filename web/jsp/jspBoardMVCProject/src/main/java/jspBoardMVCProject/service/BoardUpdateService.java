package jspBoardMVCProject.service;

import javax.servlet.http.HttpServletRequest;

import jspBoardMVCProject.model.BoardDAO;
import jspBoardMVCProject.model.BoardDTO;

public class BoardUpdateService {
	public void execute(HttpServletRequest request) {
		try {
		request.setCharacterEncoding("utf-8");
		}catch(Exception e) {}
		int boardNum  = Integer.parseInt(request.getParameter("boardNum"));
		String boardName = request.getParameter("boardName");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(boardContent);
		dto.setBoardName(boardName);
		dto.setBoardNum(boardNum);
		dto.setBoardSubject(boardSubject);
		BoardDAO dao =  new BoardDAO();
		dao.boardUpdate(dto);
	}
}
