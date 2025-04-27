package springProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("userChangePasswordDTO")
public class UserChangePasswordDTO {
	String userId;
	String userPhone;
	String userPw;	
	
	String tableName;
	String pwColumnName;
	String userIdColumnName;
	String phoneColumnName;
}









