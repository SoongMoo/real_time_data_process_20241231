package springProject.service.help;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springProject.repository.MemberRepository;

@Service
public class FindIdService {
	@Autowired
	MemberRepository memberRepository;
	public void execute(String userPhone, String userEmail, Model model) {
		Map<String , String > map = new HashMap<String, String>();
		map.put("userPhone", userPhone);
		map.put("userEmail", userEmail);
		List<String> list = memberRepository.selectId(map);
		String userId ="";
		if(list.size() > 0) userId = list.get(0);
		model.addAttribute("userId", userId);
	}
}
