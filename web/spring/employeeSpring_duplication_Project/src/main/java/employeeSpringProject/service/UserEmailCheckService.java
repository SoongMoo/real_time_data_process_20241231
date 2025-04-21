package employeeSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employeeSpringProject.repository.DuplicationRepository;

@Service
public class UserEmailCheckService {
	@Autowired
	DuplicationRepository duplicationRepository;
	public String execute(String userEmail) {
		return duplicationRepository.userEmailSelectOne(userEmail);
	}
}
