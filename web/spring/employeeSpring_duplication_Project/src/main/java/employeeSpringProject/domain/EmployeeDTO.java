package employeeSpringProject.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDTO {
	String empNum;
	String empName;
	String empId;
	String empPw;
	Date empHireDate;
}
