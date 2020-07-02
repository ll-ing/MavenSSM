package com.ll.dao;

import com.ll.bean.User;

import java.util.List;

public interface UserDao {
	User login(User user);

	int insert(User user);

	int delete(int id);

	List<User> selectUser(User user);

	int update(User user);

	User updateQueryOne(int id);



}
