package boardSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import boardSpringProject.service.BoardInsertService;

@Controller
public class BoardController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/boardList")
	public String list() {
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
}







