package springProject.command;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LibraryCommand {
	int libNum;
	@NotBlank(message = "제목을 입력하세요.")
	String libSubject;
	@NotEmpty(message = "글쓴이를 입력하세요.")
	String libWriter;
	String libContent;	
	
	MultipartFile [] libFile ;
	MultipartFile libImageFile;
}
