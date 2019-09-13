package com.example.demo.service;

import com.example.demo.domain.UserEntity;
import com.example.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<UserEntity> findOne(String userId) {
		return userRepository.findById(userId);
	}
	
	public UserEntity save(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}
	
	public void delete(String userId) {
		userRepository.deleteById(userId);
	}

}
