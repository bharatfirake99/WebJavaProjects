package com.ems.pojo;

public class Employee {
	private int empid;
	private String empname;
	private int salary;
	private String joindate;
	
	public Employee() {
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	
	@Override
	public String toString() {
		return empid+" : "+empname+" : "+salary+" : "+joindate;
	}
}
