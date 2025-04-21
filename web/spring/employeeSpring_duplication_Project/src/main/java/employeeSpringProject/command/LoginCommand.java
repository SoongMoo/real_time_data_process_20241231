package employeeSpringProject.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginCommand {
	// String @NotBlank, @NotEmpty 를 쓴다. 나머지는 @NotNull
	@NotBlank(message = "아이디를 입력해 주세요")
	String userId;
	@NotEmpty(message = "비밀번호를 입력해 주세요.")
	String userPw;
}
