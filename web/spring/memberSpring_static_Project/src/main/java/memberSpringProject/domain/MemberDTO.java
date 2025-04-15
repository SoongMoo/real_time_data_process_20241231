package memberSpringProject.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {
	String memberNum; //MEMBER_NUM
	String memberName; //MEMBER_NAME
	String memberId;
	String memberPw;
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	Date memberBirth;
}
