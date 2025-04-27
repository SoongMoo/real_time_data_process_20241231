package springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

import org.springframework.core.io.Resource;

import springProject.command.LibraryCommand;
import springProject.service.FileDownloadService;
import springProject.service.library.LibraryDeleteService;
import springProject.service.library.LibraryDetailService;
import springProject.service.library.LibraryInsertService;
import springProject.service.library.LibraryListService;
import springProject.service.library.LibraryUpdateService;

@Controller
public class LibraryController {
	@Autowired
	LibraryListService libraryListService;
	@GetMapping("/library")
	public String form(Model model) {
		libraryListService.execute(model);
		return "library/libList";
	}
	@GetMapping("/libWrite")
	public String write(LibraryCommand libraryCommand) {
		return "library/libForm";
	}
	@Autowired
	LibraryInsertService libraryInsertService;
	@PostMapping("/libWrite")
	public String write(@Validated LibraryCommand libraryCommand
			,BindingResult result) {
		if(result.hasErrors()) {
			return "library/libForm";
		}
		libraryInsertService.execute(libraryCommand);
		return "redirect:library";
	}
	@Autowired
	LibraryDetailService libraryDetailService;
	@GetMapping("/libInfo")
	public String info(Model model, int libNum) {
		libraryDetailService.execute(model, libNum);
		return "library/libDetail"; 
	}
	@Autowired
	LibraryDeleteService libraryDeleteService; 
	@GetMapping("/libDelete")
	public String delete(int libNum) {
		libraryDeleteService.execute(libNum);
		return "redirect:/library";
	}
	
	@GetMapping("/libUpdate")
	public String update(Model model, int libNum) {
		libraryDetailService.execute(model, libNum);
		return "library/libModify";
	}
	
	@Autowired
	LibraryUpdateService libraryUpdateService ;
	@PostMapping("/libUpdate")
	public String update(LibraryCommand libraryCommand, HttpSession session) {
		libraryUpdateService.execute(libraryCommand, session);
		return "redirect:libInfo?libNum="+libraryCommand.getLibNum();
	}
	@Autowired
	FileDownloadService fileDownloadService;
	@GetMapping("/libDownLoad")
	public ResponseEntity<Resource> download(String oname, String sname)throws Exception{
		return fileDownloadService.execute(oname, sname);
	}

	
}
