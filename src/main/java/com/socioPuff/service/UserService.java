package com.socioPuff.service;

import com.socioPuff.dto.UserLogin;
import com.socioPuff.dto.UserRegistrationDto;
import com.socioPuff.entity.User;

public interface UserService {

    public User getRegister(UserRegistrationDto user);

    public User getLogin(UserLogin user);
}
