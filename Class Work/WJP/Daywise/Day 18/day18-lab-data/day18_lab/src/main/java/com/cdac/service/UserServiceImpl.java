package com.cdac.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ApiException;
import com.cdac.custom_exceptions.AuthenticationException;
import com.cdac.dao.UserDao;
import com.cdac.dto.UserSignupRequest;
import com.cdac.dto.UserResp;
import com.cdac.dto.UserSignInRequest;
import com.cdac.entities.User;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	//depcy 
	private final UserDao userDao;
	private final ModelMapper modelMapper;
	

	@Override
	public UserResp registerNewUser
	(UserSignupRequest dto) {
		// 1. check for dup email
		if(userDao.existsByEmail(dto.getEmail()))
			throw new ApiException("Dup email detected !!!!!!");
		//2. req dto -> entity (de ser)
		User entity=modelMapper.map(dto, User.class);
		//3. save -> persistent entity -> resp dto (ser) 
		return modelMapper.map(userDao.save(entity),
				UserResp.class);
	}


	@Override
	public UserResp authenticateUser(UserSignInRequest dto) {
		//1. auth
		User entity=userDao.
				findByEmailAndPassword
				(dto.getEmail(), dto.getPassword())
				.orElseThrow(() -> 
				new AuthenticationException("Invalid email or password !!!!!!"));
		//2. entity -> dto : model mapper
		return modelMapper.map(entity, UserResp.class);
	}
	

}
