package memberSpringProject.command;

import lombok.Data;

@Data
public class MemberCommand {
	// command는 form 태그에 있는 이름과 같아야 한다.
	String memberNum;
	String memberId;
	String memberPw;
	String memberName;
	
}
