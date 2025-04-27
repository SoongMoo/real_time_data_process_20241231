package springProject.service.library;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springProject.command.LibraryCommand;
import springProject.domain.LibraryDTO;
import springProject.mapper.LibraryMapper;
import springProject.service.user.UserWriteService;

@Service
public class LibraryInsertService {
	@Autowired
	LibraryMapper libraryMapper;
	public void execute(LibraryCommand libraryCommand) {
		LibraryDTO dto = new LibraryDTO();
		dto.setLibContent(libraryCommand.getLibContent());
		dto.setLibSubject(libraryCommand.getLibSubject());
		dto.setLibWriter(libraryCommand.getLibWriter());
		
		// 저장 경로
		URL resource = getClass().getClassLoader().getResource("static/libUpload");
		String fileDir = resource.getFile();
		
		/* 파일 업로드 시작 */
		/* 이미지 파일 */
		if(!libraryCommand.getLibImageFile().getOriginalFilename().isEmpty()) {
			MultipartFile mf = libraryCommand.getLibImageFile();
			// 원본 파일 이름
			String originalName = mf.getOriginalFilename();
			// 저장 파일 이름 만들기
			// 확장자 찾아오기 : ???.hwp
			String extension = originalName.substring(originalName.lastIndexOf("."));
			// 저장 이름 
			String storeName = UUID.randomUUID().toString().replace("-", "");
			// 확장자를 붙인 파일 이름
			String storeFileName = storeName + extension;
			// 저장 파일 생성
			File file = new File(fileDir + "/" +storeFileName);
			try {
				// 원본이름을 저장파일이름으로 변경하여 저장
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// dto저장
			dto.setLibImageOriginalName(originalName);
			dto.setLibImageStoreName(storeFileName);
		}
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
		libraryMapper.libraryInsert(dto);
		
		// 일반 파일
	}
}
