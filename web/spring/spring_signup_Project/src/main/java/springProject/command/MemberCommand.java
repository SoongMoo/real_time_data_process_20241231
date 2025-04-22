package springProject.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemberCommand {
	@NotBlank(message = "아이디를 입력하세요.")
	String memberId;
	@NotEmpty(message = "비밀번호를 입력하세요.")
	String memberPw;
	@NotEmpty(message = "비밀번호확인을 입력하세요.")
	String memberPwCon;
	@NotEmpty(message = "이름을 입력하세요.")
	String memberName;
	@NotEmpty(message = "이메일을 입력하세요.")
	String memberEmail;
	
	public boolean isMemberPwEqualsMemberPwCon() {
		return memberPw.equals(memberPwCon);
	}
}
