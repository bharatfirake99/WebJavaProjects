package com.ems.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ems.dao.EmpManSysDao;
import com.ems.pojo.Address;
import com.ems.pojo.Employee;
import com.ems.pojo.Result;
import com.ems.dbconnection.*;
import com.ems.mapper.AddressMapper;
import com.ems.mapper.EmployeeMapper;

public class EmpManSysDaoImpl implements EmpManSysDao{
	
	@Override
	public boolean insertEmpRecord(Employee employee) {
		try(Connection con = DbConnection.getdbConnection()){
			
			PreparedStatement pst = con.prepareStatement(
					"INSERT INTO employee (empname, salary, joindate) values (?,?,?)");
			
			pst.setString(1, employee.getEmpname());
			pst.setInt(2, employee.getSalary());
			pst.setString(3, employee.getJoindate());
			
			int count = pst.executeUpdate();
			if(count > 0)
				return true;
			else
				return false;
		} catch (NullPointerException e) {
			System.out.println("connection to database failed");
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean insertAddrRecord(Address address) {
		try(Connection con = DbConnection.getdbConnection()){
			
			PreparedStatement pst = con.prepareStatement(
					"INSERT INTO address (city, country, empid) values (?,?,?)");
			
			pst.setString(1, address.getCity());
			pst.setString(2, address.getCountry());
			pst.setInt(3, address.getEmpid());
			
			int count = pst.executeUpdate();
			if(count > 0)
				return true;
			else
				return false;
		} catch (NullPointerException e) {
			System.out.println("connection to database failed");
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Result> getAllempWithAddress() {
		List<Result> list = new ArrayList<>();
		try(Connection con = DbConnection.getdbConnection()) {
			PreparedStatement pst = con.prepareStatement("SELECT emp.empid, emp.empname, "
					+ "emp.salary, emp.joindate, addr.city, addr.country " +
	                "FROM employee emp INNER JOIN address addr ON emp.empid = addr.empid");
			
			ResultSet rs = pst.executeQuery();
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					Result result = EmployeeMapper.mapEmpAddrRecords(rs);
					list.add(result);
				}
				return list;
			}
			else
				return list;
			
		} catch (NullPointerException e) {
			System.out.println("connection to database failed");
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
			list.clear();
			return list;
		}
	}

	@Override
	public Address addrByEmpId(int employeeId) {
		try(Connection con = DbConnection.getdbConnection()) {
			PreparedStatement pst = con.prepareStatement("SELECT addressid, city, "
											+ "country FROM address where empid=?");
			pst.setInt(1, employeeId);
			
			ResultSet rs = pst.executeQuery();
			if(rs.isBeforeFirst()) {
				rs.next();
				Address address = AddressMapper.mapAddRecords(rs);
				return address;
			}
			else
				return null;
		} catch (NullPointerException e) {
			System.out.println("connection to database failed");
			return null;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Employee empByCity(String city) {
		try(Connection con = DbConnection.getdbConnection()) {
			PreparedStatement pst = con.prepareStatement("SELECT emp.empid, "
					+ "emp.empname, emp.salary, emp.joindate, addr.city, "
					+ "addr.country FROM employee emp INNER JOIN address addr "
					+ "ON emp.empid = addr.empid WHERE addr.city = ?");
			pst.setString(1, city);
			ResultSet rs = pst.executeQuery();
			if(rs.isBeforeFirst()) {
				rs.next();
				Employee employee = EmployeeMapper.mapEmpRecords(rs);
				return employee;
			}else
				return null;			
		} catch (NullPointerException e) {
			System.out.println("connection to database failed");
			return null;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Employee empWithHighSal() {
		try(Connection con = DbConnection.getdbConnection()) {
			PreparedStatement pst = con.prepareStatement("SELECT empid, empname, "
					+ "salary, joindate FROM employee where salary=(Select MAX(salary) "
					+ "from employee)");
			
			ResultSet rs = pst.executeQuery();
			if(rs.isBeforeFirst()) {
				rs.next();
				Employee employee = EmployeeMapper.mapEmpRecords(rs);
				return employee;
			}
			else
				return null;
		} catch (NullPointerException e) {
			System.out.println("connection to database failed");
			return null;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Employee empWithExpMoreThan5() {
		try(Connection con = DbConnection.getdbConnection()) {
			PreparedStatement pst = con.prepareStatement("SELECT empid, empname, "
					+ "salary, joindate FROM employee WHERE DATEDIFF(CURDATE(), "
					+ "joindate) > 1825");
			
			ResultSet rs = pst.executeQuery();
			if(rs.isBeforeFirst()) {
				rs.next();
				Employee employee = EmployeeMapper.mapEmpRecords(rs);
				return employee;
			}
			else
				return null;
		} catch (NullPointerException e) {
			System.out.println("connection to database failed");
			return null;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
