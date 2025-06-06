package com.cdac.service;

import com.cdac.dto.ApiResponse;
import com.cdac.dto.UserSignupRequest;
import com.cdac.dto.UserSignupResp;

public interface UserService {

	UserSignupResp registerNewUser(UserSignupRequest dto);

}
