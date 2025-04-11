package boardSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import boardSpringProject.command.BoardCommand;
import boardSpringProject.service.BoardDeleteService;
import boardSpringProject.service.BoardDetailServie;
import boardSpringProject.service.BoardListService;
import boardSpringProject.service.BoardUpdateService;
import boardSpringProject.service.BoardWriteService;

@Controller
public class BoardController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@Autowired
	BoardListService boardListService ;
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
	BoardWriteService boardWriteService ;
	@PostMapping("/boardWrite")
	public String write(BoardCommand boardCommand) {
		boardWriteService.execute(boardCommand);
		return "redirect:boardList";
	}
	@Autowired
	BoardDetailServie boardDetailServie;
	@GetMapping("/boardDetail")
	public String boardDetail(String boardNum, Model model) {
		boardDetailServie.execute(boardNum, model);
		return "board/boardDetail";
	}
	
	@GetMapping("/boardModify")
	public String modify(String boardNum, Model model) {
		boardDetailServie.execute(boardNum, model);
		return "board/boardUpdate";
	}
	@Autowired
	BoardUpdateService boardUpdateService;
	@PostMapping("boardModify")
	public String modify(BoardCommand boardCommand) {
		boardUpdateService.execute(boardCommand);
		return "redirect:boardDetail?boardNum="+boardCommand.getBoardNum();
	}
	
	@Autowired
	BoardDeleteService boardDeleteService ;
	@GetMapping("boardDelete")
	public String delete(String boardNum) {
		boardDeleteService.execute(boardNum);
		return "redirect:boardList";
	}
	
	
	
	
	
	
	
	
	
}
