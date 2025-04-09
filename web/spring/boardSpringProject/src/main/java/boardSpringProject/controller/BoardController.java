package boardSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import boardSpringProject.service.BoardDeleteService;
import boardSpringProject.service.BoardDetailService;
import boardSpringProject.service.BoardListService;
import boardSpringProject.service.BoardUpdateService;
import boardSpringProject.service.BoardWriteService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	@Autowired
	BoardWriteService boardWriteService;
	@Autowired
	BoardListService boardListService;
	@Autowired
	BoardDetailService boardDetailService;
	@Autowired
	BoardUpdateService boardUpdateService;
	@Autowired
	BoardDeleteService boardDeleteService;
	@RequestMapping("boardList.nhn") // get/post
	//if(command.equals("/boardList.nhn")) {}
	public String boardList(HttpServletRequest request) {
		//BoardListService boardListService = new BoardListService();
		boardListService.execute(request);
		return "boardList";
	}
	@RequestMapping(value="boardWrite.nhn", method=RequestMethod.GET)
	public String boardWrite() {
		return "boardForm";
	}
	@RequestMapping(value="boardWrite.nhn", method=RequestMethod.POST)
	public String boardWrite(HttpServletRequest request) {
		boardWriteService.execute(request);
		return "redirect:boardList.nhn";
	}
	@GetMapping("boardDetail.nhn")
	public String boardInfo(HttpServletRequest request) {
		boardDetailService.execute(request);
		return "boardDetail";
	}
	@GetMapping("boardModify.nhn")
	public String boardModify(HttpServletRequest request) {
		boardDetailService.execute(request);
		return "boardUpdate";
	}
	
	@PostMapping(value="boardModify.nhn")
	public String boardUpdate(HttpServletRequest request) {
		boardUpdateService.execute(request);
		return "redirect:boardDetail.nhn?boardNum="
					+request.getParameter("boardNum");
	}
	@GetMapping("boardDelete.nhn")
	public String boardDelete(HttpServletRequest request) {
		boardDeleteService.execute(request);
		return "redirect:boardList.nhn";
	}
	
}






