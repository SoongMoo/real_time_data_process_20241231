package jspBoardMVCProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspBoardMVCProject.service.BoardDeleteService;
import jspBoardMVCProject.service.BoardDetailService;
import jspBoardMVCProject.service.BoardListService;
import jspBoardMVCProject.service.BoardUpdateService;
import jspBoardMVCProject.service.BoardWriteService;
@WebServlet("*.naver")
public class BoardFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/boardList.naver")) {
			System.out.println("게시글 리스트");
			BoardListService action = new BoardListService();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/board/boardList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardWrite.naver")) {
			System.out.println("게시글 쓰기");
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/board/boardForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardDetail.naver")) {
			System.out.println("게시글 상세보기");
			BoardDetailService action = new BoardDetailService();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/board/boardDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardModify.naver")) {
			BoardDetailService action = new BoardDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/board/boardUpdate.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardDelete.naver")) {
			BoardDeleteService action = new BoardDeleteService();
			action.execute(request);
			response.sendRedirect("boardList.naver");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/boardWrtie.naver")) {
			BoardWriteService action = new BoardWriteService();
			action.execute(request);
			response.sendRedirect("boardList.naver");
		}else if(command.equals("/boardModify.naver")) {
			BoardUpdateService action = new BoardUpdateService();
			action.execute(request);
			response.sendRedirect("boardDetail.naver?boardNum="
								+request.getParameter("boardNum"));
		}
	}
}







