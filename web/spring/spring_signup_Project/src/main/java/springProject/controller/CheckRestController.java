package springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import springProject.service.EmailCheckService;
import springProject.service.FileDelService;

@RestController // String , Map, List, dto, Integer : html제외
public class CheckRestController {
	@Autowired
	EmailCheckService emailCheckService;
	@GetMapping("/help/userConfirm")
	public String confr(String chk) {
		Integer i = emailCheckService.execute(chk);
		if(i != 0) return "인증되었습니다.";
		else return "이미 인증되었습니다.";
	}
	@Autowired
	FileDelService fileDelService;
	@PostMapping("/file/fileDel")
	public int fileDel(String orgFile, String storeFile, HttpSession session) {
		return  fileDelService.execute(orgFile, storeFile, session);
	}
}



