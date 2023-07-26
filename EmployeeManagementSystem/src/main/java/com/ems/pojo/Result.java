package com.ems.pojo;

public class Result {
	
	private Employee employee;
	private Address address;
	
	public Result(Employee employee, Address address) {
		this.employee = employee;
		this.address = address;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return employee.getEmpid()+" : "+employee.getEmpname()+" : "
				+employee.getSalary()+" : "+employee.getJoindate()+" : "
				+address.getCity()+" : "+address.getCountry();
	}
}
