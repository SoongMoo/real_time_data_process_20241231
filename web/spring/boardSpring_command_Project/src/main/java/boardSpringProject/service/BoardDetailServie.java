package boardSpringProject.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import boardSpringProject.domain.BoardDTO;
import boardSpringProject.repository.BoardDAO;

@Service
public class BoardDetailServie {
	BoardDAO dao = new BoardDAO(); 
	public void execute(String boardNum, Model model) {
		BoardDTO dto = dao.boardSelectOne(boardNum);
		model.addAttribute("dto", dto);
	}
}
