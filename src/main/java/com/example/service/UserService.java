package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;
	
	/**
	 * ユーザー情報を登録する.
	 * 
	 * @param user user
	 */
	public void insert(User user) {
		repository.insert(user);
	}
}
