package com.ll.service;

import java.util.List;

import com.ll.bean.User;

public interface UserService {
	User login(User user);
	int insert(User user);
	int delete(int id);
	List<User> selectUser(User user);
	int update(User user);
	User updateQueryOne(int id);
}
