package com.netease.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.netease.domain.New_User;

public interface NewUserRepository extends CrudRepository<New_User, Integer> {
	public List<New_User> findAll();
	@SuppressWarnings("unchecked")
	public New_User save(New_User user);
	public New_User findByMobileNumber(String mobileNumber);
}
