package springProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("auth")
public class AuthInfoDTO {
	String userId;
	String userPw;
	String userEmail;
	String userName;
	String grade;
}
