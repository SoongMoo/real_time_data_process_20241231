package springProject.service.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springProject.domain.LibraryDTO;
import springProject.mapper.LibraryMapper;

@Service
public class LibraryListService {
	@Autowired
	LibraryMapper libraryMapper;
	public void execute(Model model) {
		List<LibraryDTO> list = libraryMapper.libSelectList();
		model.addAttribute("list", list);
	}
}
