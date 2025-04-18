package employeeSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employeeSpringProject.repository.DulicationRepository;

@Service
public class IdcheckService {
	@Autowired
	DulicationRepository dulicationRepository; 
	public String execute(String userId) {
		return dulicationRepository.idCheckSelectOne(userId);
	}
}
