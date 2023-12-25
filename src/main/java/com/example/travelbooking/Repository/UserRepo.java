package com.example.MobileStoreSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MobileStoreSystem.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

	@Query(value =  "select * from User where userName =?" , nativeQuery = true)
	User findByUserName(String userName);

	
}