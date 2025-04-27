package springProject.service.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springProject.domain.LibraryDTO;
import springProject.mapper.LibraryMapper;

@Service
public class LibraryDetailService {
	@Autowired
	LibraryMapper libraryMapper;
	public void execute(Model model, int libNum) {
		LibraryDTO dto = libraryMapper.libSelectOne(libNum);
		model.addAttribute("libraryCommand", dto);
	}
}
