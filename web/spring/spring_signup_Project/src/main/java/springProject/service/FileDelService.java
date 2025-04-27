package springProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springProject.domain.FileDTO;

@Service
public class FileDelService {
	public int execute(String orgFile, String storeFile, HttpSession session) {
		int i = 0;
		FileDTO dto = new FileDTO();
		dto.setOrgFile(orgFile);
		dto.setStoreFile(storeFile);
		Boolean newFile = true;  // session에 파일정보가 있는지 확인
		// session에 파일 정보가 있는지 session정보 가져오기
		List<FileDTO> list = (List<FileDTO>)session.getAttribute("fileList");
		// session 없는 경우
		// 처음 삭제시에는 session이 없으므로 list객체를 생성
		if(list == null) {
			list = new ArrayList<FileDTO>();
		}
		// session이 있는 경우 파일이 있는 경우
		for(FileDTO fd : list) {
			if(fd.getOrgFile().equals(orgFile)) {
				list.remove(fd); // session에 있는 파일 정보를 삭제
				newFile = false;
				break;
			}
		}
		if(newFile) { // session에 파일정보가 없는 경우 추가
			list.add(dto);
			i = 1;
		}
		session.setAttribute("fileList", list);
		return i;
	}
}
