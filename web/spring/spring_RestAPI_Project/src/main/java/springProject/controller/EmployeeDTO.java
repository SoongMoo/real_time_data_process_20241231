package springProject.controller;

import java.util.Date;


public class EmployeeDTO {
	String empNum;
	String empName;
	String empId;
	String empPw;
	Date empHireDate;
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpPw() {
		return empPw;
	}
	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
	public Date getEmpHireDate() {
		return empHireDate;
	}
	public void setEmpHireDate(Date empHireDate) {
		this.empHireDate = empHireDate;
	}	
}
