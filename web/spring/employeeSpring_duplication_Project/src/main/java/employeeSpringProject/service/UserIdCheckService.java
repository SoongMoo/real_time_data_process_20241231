package employeeSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employeeSpringProject.repository.DuplicationRepository;

@Service
public class UserIdCheckService {
	@Autowired
	DuplicationRepository duplicationRepository;
	public String execute(String userId) {
		String id = duplicationRepository.userIdSelectOne(userId);
		return id;
	}
}
