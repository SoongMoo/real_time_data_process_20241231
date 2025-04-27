package springProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springProject.repository.MemberRepository;

@Service
public class EmailCheckService {
	@Autowired
	MemberRepository memberRepository;
	public Integer execute(String userId) {
		return memberRepository.emailCheckUpdate(userId);
	}
}
