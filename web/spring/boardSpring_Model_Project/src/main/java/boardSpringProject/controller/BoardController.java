package boardSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import boardSpringProject.service.BoardDeleteService;
import boardSpringProject.service.BoardDetailService;
import boardSpringProject.service.BoardInsertService;
import boardSpringProject.service.BoardListService;
import boardSpringProject.service.BoardUpdateService;

@Controller
public class BoardController {
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@Autowired
	BoardListService boardListService; 
	@GetMapping("/boardList")
	public String list(Model model) {
		boardListService.execute(model);
		return "/board/boardList";
	}
	@GetMapping("/boardWrite")
	public String write() {
		return "/board/boardForm";
	}
	@Autowired
	BoardInsertService boardInsertService;
	
	@PostMapping("/boardWrite")
	public String write(String boardWriter
			,String boardSubject
			,String boardContent) {
		//String boardContent = request.getParameter("boardContent");
		boardInsertService.execute(boardWriter, boardSubject, boardContent);
		return "redirect:/boardList";
	}
	@Autowired
	BoardDetailService boardDetailService;
	@GetMapping("/boardDetail")
	public String detail(String boardNum, Model model) {
		boardDetailService.execute(boardNum, model);
		return "/board/boardDetail";
	}
	
	@GetMapping("/boardModify")
	public String modify(String boardNum, Model model) {
		boardDetailService.execute(boardNum, model);
		return "board/boardUpdate";
	}
	@Autowired
	BoardUpdateService boardUpdateService;
	@RequestMapping("/boardModify1")
	public String modify(String boardNum, String boardWriter, String boardSubject
			            ,String boardContent) {
		boardUpdateService.execute(boardNum, boardWriter,boardSubject,boardContent);
		return "redirect:boardDetail?boardNum="+boardNum;
	}
	@Autowired
	BoardDeleteService boardDeleteService;
	@GetMapping("/boardDelete")
	public String delete(String boardNum) {
		boardDeleteService.execute(boardNum);
		return "redirect:boardList";
	}
}







