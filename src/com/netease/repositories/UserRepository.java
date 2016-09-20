package com.netease.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.netease.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public List<User> findAll();

	public User save(User user);

	public User findByName(String name);

	public User getByLoginName(String loginName);

	public List<User> findByCreateUser(String createUser);
	
	public User findByMobileNumber(BigInteger mobileNumber);

	public User findById(Integer id);
	
	@Transactional
	@Modifying
	@Query("update User set report_status=:report_status where login_name=:login_name")
    public Integer updateByLoginName(@Param("report_status") Integer report_status,
    		@Param("login_name") String login_name);

}
