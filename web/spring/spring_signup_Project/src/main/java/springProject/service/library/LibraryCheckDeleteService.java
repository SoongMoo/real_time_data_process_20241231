package springProject.service.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springProject.mapper.LibraryMapper;

@Service
public class LibraryCheckDeleteService {
	@Autowired
	LibraryMapper libraryMapper;
	public void execute(int nums[]) {
		libraryMapper.libraryNumsDelete(nums);
	}
}
