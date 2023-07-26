package com.ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ems.pojo.Address;
import com.ems.pojo.Employee;
import com.ems.pojo.Result;

public class EmployeeMapper {
	public static Result mapEmpAddrRecords(ResultSet rs) throws SQLException{
		Employee employee = new Employee();
		Address address = new Address();
		employee.setEmpid(rs.getInt("empid"));
		employee.setEmpname(rs.getString("empname"));
		employee.setSalary(rs.getInt("salary"));
		employee.setJoindate(rs.getString("joindate"));
		address.setCity(rs.getString("city"));
		address.setCountry(rs.getString("country"));
		Result result = new Result(employee, address);
		return result;
	}
	
	public static Employee mapEmpRecords(ResultSet rs) throws SQLException{
		Employee employee = new Employee();
		employee.setEmpid(rs.getInt("empid"));
		employee.setEmpname(rs.getString("empname"));
		employee.setSalary(rs.getInt("salary"));
		employee.setJoindate(rs.getString("joindate"));
		return employee;
	}
}
