package springProject.service;

import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FileDownloadService {
	public ResponseEntity<Resource> execute(String oname, String sname) throws Exception{
		URL urlResource = getClass().getClassLoader().getResource("static/libUpload/" + sname);
		Path filePath = Paths.get(urlResource.toURI());
		Resource resource = new UrlResource(filePath.toUri());
		//파일이름이 한글 이름일때 브라우저가 인식하지 못할 경우
		String encodedFilename = URLEncoder.encode(oname, "UTF-8").replaceAll("\\+", "%20");
		return ResponseEntity.ok()
		        .contentType(MediaType.APPLICATION_OCTET_STREAM) // 바이너리 파일
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + encodedFilename) // 다운로드 이름 변경
		        .body(resource);
	}
}
