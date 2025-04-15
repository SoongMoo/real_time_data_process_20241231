package memberSpringProject.domain;

import lombok.Data;

// vo, dto, domain
@Data
public class MemberDTO {
	// 테이블의 컬럼과 같아야 한다.
	String memberNum;//MEMBER_NUM
	String memberName;
	String memberId;
	String memberPw;
}
