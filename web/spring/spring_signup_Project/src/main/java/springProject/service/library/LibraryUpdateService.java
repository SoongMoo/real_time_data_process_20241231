package springProject.service.library;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import springProject.command.LibraryCommand;
import springProject.domain.FileDTO;
import springProject.domain.LibraryDTO;
import springProject.mapper.LibraryMapper;

@Service
public class LibraryUpdateService {
	@Autowired
	LibraryMapper libraryMapper;
	public void execute(LibraryCommand libraryCommand, HttpSession session) {
		LibraryDTO dto = new LibraryDTO();
		dto.setLibContent(libraryCommand.getLibContent());
		dto.setLibNum(libraryCommand.getLibNum());
		dto.setLibSubject(libraryCommand.getLibSubject());
		dto.setLibWriter(libraryCommand.getLibWriter());

		URL resource = getClass().getClassLoader().getResource("static/libUpload");
		String fileDir = resource.getFile();
		// 단일 파일 추가		
		if(libraryCommand.getLibImageFile() != null && !libraryCommand.getLibImageFile().isEmpty()) {
			MultipartFile mf = libraryCommand.getLibImageFile();
			String originalName = mf.getOriginalFilename();
			String extension = originalName.substring(originalName.lastIndexOf("."));
			String storeName = UUID.randomUUID().toString().replace("-", "");
			String storeFileName = storeName + extension;
			File file = new File(fileDir + "/" +storeFileName);
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setLibImageOriginalName(originalName);
			dto.setLibImageStoreName(storeFileName);
		}
		
		// multiple 파일 추가
		if(!libraryCommand.getLibFile()[0].getOriginalFilename().isEmpty()) {
			String totalOriginalName = "";
			String totalStoreName = "";
			for(MultipartFile mf : libraryCommand.getLibFile()) {
				String originalName = mf.getOriginalFilename();
				String extension = originalName.substring(originalName.lastIndexOf("."));
				String storeName = UUID.randomUUID().toString().replace("-", "");
				String storeFileName = storeName + extension;
				File file = new File(fileDir + "/" +storeFileName);
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				totalOriginalName += originalName + "`";
				totalStoreName += storeFileName + "`";
			}
			dto.setLibOriginalName(totalOriginalName);
			dto.setLibStoreName(totalStoreName);
		}
		// session에 있는 파일정보 , 디비에서 session에 있는 파일정보 제거
		List<FileDTO> list = (List<FileDTO>) session.getAttribute("fileList");
		LibraryDTO libraryDTO = libraryMapper.libSelectOne(dto.getLibNum());
		
		
		// 디비에서 불러온 자료실 정보에서 list에 있는 파일정보 제거
		// multiple 파일 삭제 처리
		if(libraryDTO.getLibOriginalName() != null) { // 수정
												 // 배열을 리스트로 변환: Arrays.asList()
										         // 데이터베이스로 부터 받아온 파일을 리스트로 저장
			List<String> dbOrg = new ArrayList<>(Arrays.asList(libraryDTO.getLibOriginalName().split("`")));
			List<String> dbStore = new ArrayList<>(Arrays.asList(libraryDTO.getLibStoreName().split("`")));
			if (list != null) {
				for(FileDTO fd : list) { //  리스트의 파일정보 반복
					for(String store : dbStore) { // 원본 파일명들을 반복
						if(fd.getStoreFile().equals(store)) { // 파일정보와 디비원본 파일 비교
							// session에 있는 파일명과 같은 이름의 파일정보를 디비정보로 부터 삭제
							dbOrg.remove(fd.getOrgFile()); 
							dbStore.remove(fd.getStoreFile());  
							break;
						}
					}
				}
			}
			
			// 새로운 파일과 제거된 데이터베이스 파일 정보와 합친다.-- 수정
			String totalOrigianlName = dto.getLibOriginalName();
			if(totalOrigianlName == null) totalOrigianlName = "";
			String totalStoreName = dto.getLibStoreName();
			if(totalStoreName == null) totalStoreName = "";
			
			for(String ostr : dbOrg) {
				totalOrigianlName += ostr + "`";
			}
			for(String sstr : dbStore) {
				totalStoreName += sstr  + "`" ;
			}
			dto.setLibOriginalName(totalOrigianlName);
			dto.setLibStoreName(totalStoreName);
		}
		// 단일 파일 처리
		if (libraryCommand.getLibImageFile() != null) {
			if(libraryDTO.getLibImageStoreName() != null && libraryCommand.getLibImageFile().isEmpty()) {
				if (list != null) {
					for(FileDTO fd : list) { 
						System.out.println("삭제");
						if(fd.getStoreFile().equals(libraryDTO.getLibStoreName())) {
							dto.setLibImageOriginalName(null);
							dto.setLibImageStoreName(null);
						}
					}
				}
			}
		}else {
			dto.setLibImageOriginalName(libraryDTO.getLibImageOriginalName());
			dto.setLibImageStoreName(libraryDTO.getLibImageStoreName());
		}
		// 데이터 베이스 수정
		int i = libraryMapper.libraryUpdate(dto);
		
		// session에 있는 파일 삭제
		if(i != 0) {
			if(list != null) {
				for(FileDTO fd : list) {
					File file = new File(fileDir + "/" + fd.getStoreFile());
					if (file.exists()) file.delete();
				}
			}
		}
		// session 삭제
		session.removeAttribute("fileList");
	}
}
