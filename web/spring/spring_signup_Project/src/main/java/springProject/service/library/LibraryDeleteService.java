package springProject.service.library;

import java.io.File;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springProject.domain.LibraryDTO;
import springProject.mapper.LibraryMapper;

@Service
public class LibraryDeleteService {
	@Autowired
	LibraryMapper libraryMapper;
	public void execute(int libNum) {
		LibraryDTO dto = libraryMapper.libSelectOne(libNum);
		
		int i = libraryMapper.libraryDelete(libNum);
		if(i != 0) {
			// 저장 경로
			URL resource = getClass().getClassLoader().getResource("static/libUpload");
			String fileDir = resource.getFile();
			File file = new File(fileDir + "/" + dto.getLibImageStoreName());
			if(file.exists()) file.delete();
			if(dto.getLibStoreName() != null) { // 
				for(String fileName : dto.getLibStoreName().split("`")) {
					file = new File(fileDir + "/" + fileName);
					if(file.exists()) file.delete();
				}
			}
			
		}
	}
}




