package boardSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import boardSpringProject.domain.BoardDTO;
import boardSpringProject.repository.BoardDAO;

@Service
public class BoardDetailService {
	@Autowired
	BoardDAO boardDAO ;
	public void execute(String boardNum, Model model) {
		BoardDTO dto = boardDAO.boardSelectOne(boardNum);
		model.addAttribute("dto",dto);
	}
}














