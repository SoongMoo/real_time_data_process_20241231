package jspBoardMVCProject.service;

import javax.servlet.http.HttpServletRequest;

import jspBoardMVCProject.model.BoardDAO;
import jspBoardMVCProject.model.BoardDTO;

public class BoardWriteService {
	public void execute(HttpServletRequest request) {
		try {
		request.setCharacterEncoding("utf-8");
		}catch(Exception e) {}
		
		String boardName = request.getParameter("boardName");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		BoardDTO dto = new BoardDTO();
		dto.setBoardName(boardName);
		dto.setBoardSubject(boardSubject);
		dto.setBoardContent(boardContent);
		BoardDAO dao = new BoardDAO();
		dao.boardInsert(dto);
	}
}
