package boardSpringProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import boardSpringProject.domain.BoardDTO;
import boardSpringProject.repository.BoardDAO;

@Service
public class BoardListService {
	@Autowired
	BoardDAO boardDAO;
	public void execute(Model model) {
		List<BoardDTO> list = boardDAO.boardSelectAll();
		model.addAttribute("list", list);
	}
}




