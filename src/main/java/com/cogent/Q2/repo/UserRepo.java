package com.cogent.Q2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cogent.Q2.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	User findByUserName(String username);
}
