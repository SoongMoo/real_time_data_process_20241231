package springProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("mem")
public class MemberDTO {
	String memberId;
	String memberPw;
	String memberName;
	String memberEmail;
}






