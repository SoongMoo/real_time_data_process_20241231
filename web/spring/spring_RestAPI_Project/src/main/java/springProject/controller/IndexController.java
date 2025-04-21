package springProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // html문서를 전송할 때 사용
public class IndexController {
	@GetMapping("/test")
	public String index() {
		return "index";
	}
}
