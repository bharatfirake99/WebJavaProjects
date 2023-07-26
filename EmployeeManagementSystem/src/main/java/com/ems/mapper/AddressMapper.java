package com.ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ems.pojo.Address;

public class AddressMapper {
	public static Address mapAddRecords(ResultSet rs) throws SQLException{
		Address address = new Address();
		address.setAddressid(rs.getInt("addressid"));
		address.setCity(rs.getString("city"));
		address.setCountry(rs.getString("country"));
		//address.setEmpid(rs.getInt("empid"));
		return address;
	}
}
