package com.sociopuff.service;

import com.sociopuff.dto.UserLogin;
import com.sociopuff.dto.UserRegistrationDto;
import com.sociopuff.entity.User;

/***
 *  This Interface contains all methods used for User control management system
 */
public interface UserService {

    public User getRegister(UserRegistrationDto user);

    public User getLogin(UserLogin user);

    public UserLogin getLogout(UserLogin user);

    public User forgetPassword(UserLogin userLogin);
}
