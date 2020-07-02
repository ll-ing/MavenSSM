package com.ll.service;

import java.util.List;

import com.ll.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ll.dao.UserDao;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userdao;
	public User login(User user) {
	User u = userdao.login(user);	
		return u;
	}
	@Override
	public int insert(User user) {
		int n=userdao.insert(user);
		return n;
	}
	@Override
	public int delete(int id) {
		
		return  userdao.delete(id);
	}
	@Override
	public List<User> selectUser(User user) {
		List<User> list = userdao.selectUser(user);
		return list;
	}
	
	@Override
	public int update(User user) {
		
		return userdao.update(user);
	}

	@Override
	public User updateQueryOne(int id) {
		return userdao.updateQueryOne(id);
	}


}