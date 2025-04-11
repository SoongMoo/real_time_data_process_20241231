package boardSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import boardSpringProject.domain.BoardDTO;
import boardSpringProject.repository.BoardRepository;

@Service
public class BoardDetailService {
	@Autowired
	BoardRepository boardRepository;
	public void execute(String boardNum, Model model) {
		BoardDTO dto = boardRepository.boardSelectOne(boardNum);
		model.addAttribute("dto", dto);		
	}
}
