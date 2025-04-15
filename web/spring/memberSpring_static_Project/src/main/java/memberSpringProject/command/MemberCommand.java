package memberSpringProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {
	// form데이터를 가져오기 위해 form에 있는 이름과 멤버필드명이 같아야 한다.
	String memNum;
	String memId;
	String memPw;
	String memName;
	String memAddr;
	String memDetailAddr;
	String memPost;
	// SimpleDateFormat
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memBirth;
}
