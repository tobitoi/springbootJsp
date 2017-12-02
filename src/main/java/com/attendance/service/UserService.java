package com.attendance.service;

import java.util.List;

import com.attendance.model.Role;
import com.attendance.model.User;

public interface UserService {
	List<User> userList();
	
	User findOne(Long id);
	
	String addUser(User user);
	
	String deleteUser(Long id);
	
	List<Role> roleList();
}
