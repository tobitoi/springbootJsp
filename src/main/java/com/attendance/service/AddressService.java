package com.attendance.service;

import java.util.List;

import com.attendance.model.Address;

public interface AddressService {
	List<Address> addressList();
	
	Address findOne(Long id);
	
	String addAddress(Address address);
	
	String deleteAddress(Long id);
}
