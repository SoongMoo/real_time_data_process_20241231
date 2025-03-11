package jspBoardMVCProject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspBoardMVCProject.model.BoardDAO;
import jspBoardMVCProject.model.BoardDTO;

public class BoardListService {
	//dao로 부터 받아온 값을 저장하려면 request가 필요하다.
	public void execute(HttpServletRequest request) {
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.boardSelectAll();
		// list를 jsp로 보내기 위해 request에 저장해서 보낸다.
		request.setAttribute("dtos", list);
		//                     key  value
	}
}
