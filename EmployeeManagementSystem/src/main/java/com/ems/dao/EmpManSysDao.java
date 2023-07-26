package com.ems.dao;

import java.util.List;

import com.ems.pojo.Address;
import com.ems.pojo.Employee;
import com.ems.pojo.Result;

public interface EmpManSysDao {
	boolean insertEmpRecord(Employee employee);
	boolean insertAddrRecord(Address address);
	List<Result> getAllempWithAddress();
	Address addrByEmpId(int employeeId);
	Employee empByCity(String city);
	Employee empWithHighSal();
	Employee empWithExpMoreThan5();	
}
