package com.ems.emsmain;

import java.util.List;
import java.util.Scanner;

import com.ems.dao.EmpManSysDao;
import com.ems.daoimplementation.EmpManSysDaoImpl;
import com.ems.pojo.Address;
import com.ems.pojo.Employee;
import com.ems.pojo.Result;

public class EmpMangSysMain {

	public static void main(String[] args) {
		EmpManSysDao emsd = new EmpManSysDaoImpl();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			System.out.println();
			System.out.println("-------- Employee Management System --------");
            System.out.println("1. Add Employee");
            System.out.println("2. Add Address");
            System.out.println("3. Select Employee Records with Address");
            System.out.println("4. Select Address of Employee by ID");
            System.out.println("5. Select Employee by City");
            System.out.println("6. Select Employee with Highest Salary");
            System.out.println("7. Select Employees with Experience > 5 years");
            System.out.println("0. Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            
            switch(choice) {
            case 1:
            	Employee employee = new Employee();
            	System.out.println("Enter the name of employee : ");
            	employee.setEmpname(sc.next());
            	System.out.println("Enter the salary of employee : ");
            	employee.setSalary(sc.nextInt());
            	System.out.println("Enter the date of joining of employee : ");
            	employee.setJoindate(sc.next());
            	if(emsd.insertEmpRecord(employee))
            		System.out.println("Employee Record Inserted");
            	else
            		System.out.println("Failed to insert record");
            	
            	break;
            case 2:
            	Address address = new Address();
            	System.out.println("Enter the employee city : ");
            	address.setCity(sc.next());
            	System.out.println("Enter the employee country : ");
            	address.setCountry(sc.next());
            	System.out.println("Enter the employee id : ");
            	address.setEmpid(sc.nextInt());
            	if(emsd.insertAddrRecord(address))
            		System.out.println("Address record inserted");
            	else
            		System.out.println("Failed to insert record");
            	
            	break;
            case 3:
            	List<Result> list = emsd.getAllempWithAddress();
        		if(list.size()>0) {
        			System.out.println();
        			System.out.println("*******Employee details*******");
        			list.forEach(System.out::println);
        		}
        		else
        			System.out.println("No Employee Record Found!!!!!!!!");
        		break;
            case 4:
            	Address address1 = emsd.addrByEmpId(4);
        		if(address1 != null)
        			System.out.println(address1);
        		else
        			System.out.println("No Record");
        		break;
            case 5:
            	System.out.println("Enter the name of city : ");
            	String city = sc.next();
            	Employee employee1 = emsd.empByCity(city);
        		if(employee1 != null)
        			System.out.println(employee1);
        		else
        			System.out.println("No Record");
        		break;
            case 6:
            	Employee employee2 = emsd.empWithHighSal();
        		if(employee2 != null)
        			System.out.println(employee2);
        		else
        			System.out.println("No Record");
        		break;
            case 7:
            	Employee employee3 = emsd.empWithExpMoreThan5();
        		if(employee3 != null)
        			System.out.println(employee3);
        		else
        			System.out.println("No Record");
        		break;	
            case 0 : 
            	exit = true;
            	break;
            default : 
            	System.out.println("Invalid choice. Please try again.");
            	break;
            }
		}
		sc.close();
	}
}

