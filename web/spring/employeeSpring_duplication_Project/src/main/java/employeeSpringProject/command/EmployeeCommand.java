package employeeSpringProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class EmployeeCommand {
	/// 자료형이 String @NotEmpty, @NotBlank를 사용할 수 있다.
	/// String이 아닌 자료형은 @NotNull이다 
	String empNum;
	@NotBlank(message = "이름을 입력해주세요.")
	String empName;
	@NotEmpty(message = "아이디를 입력해주세요.")
	String empId;
	@NotEmpty(message = "비밀번호를 입력해주세요.")
	String empPw;
	
	String empPwCon;
	
	@NotNull(message = "입사일을 입력하세요.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date empHireDate;
	
	public boolean isEmpPwEquealsEmpPwCon() {
		if(empPw.equals(empPwCon)) {
			return true;
		}else {
			return false;
		}
	}

	
}



