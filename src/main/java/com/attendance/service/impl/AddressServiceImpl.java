package com.attendance.service.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.model.Address;
import com.attendance.model.User;
import com.attendance.repository.AddressRepository;
import com.attendance.repository.UserRepository;
import com.attendance.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	private AddressRepository addressRepository;
	private UserRepository userRepository;

	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Address> addressList() {
		return addressRepository.findAll();
	}

	@Override
	public Address findOne(Long id) {
		return addressRepository.findOne(id);
	}

	@Override
	public String addAddress(Address address) { 
		String message = null;
		JSONObject jsonObject = new JSONObject();
		try {
			if (address.getId() == null) {
				message = "Added";
			} else {
				message = "Updated";
			}
			User user = userRepository.findOne(address.getUserId());
			address.setUser(user); 
			addressRepository.save(address);
			jsonObject.put("status", "success");
			jsonObject.put("title", message+" Confirmation");
			jsonObject.put("message", "Address for "+user.getFullName() +" "+ message + " successfully.");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	public String deleteAddress(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			addressRepository.delete(id);
			jsonObject.put("message", "Address Deleted Successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
}
