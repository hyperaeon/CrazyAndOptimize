package com.netease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.domain.New_User;
import com.netease.repositories.NewUserRepository;

@Service
public class NewUserService {
	@Autowired
	private  NewUserRepository newUserRepository;
	public List<New_User> findAll()
	{
		return newUserRepository.findAll();
	}
	public New_User save(New_User user) {
		return newUserRepository.save(user);
	}
	
	public New_User findUserByMobileNumber(String mobileNumber){
		return newUserRepository.findByMobileNumber(mobileNumber);
	}

}
