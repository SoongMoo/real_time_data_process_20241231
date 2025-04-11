package boardSpringProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import boardSpringProject.domain.BoardDTO;
import boardSpringProject.repository.BoardRepository;

@Service
public class BoardListService {
	@Autowired
	BoardRepository boardRepository;
	public void execute(Model model) {
		List<BoardDTO> list = boardRepository.boardSelectAll();
		model.addAttribute("list", list);
 	}
}







