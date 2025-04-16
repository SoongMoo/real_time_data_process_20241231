package employeeSpringProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmployeeCommand {
	String empNum;
	String empName;
	String empId;
	String empPw;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date empHireDate;
}
