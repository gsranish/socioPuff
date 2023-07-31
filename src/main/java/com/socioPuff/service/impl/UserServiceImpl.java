package com.socioPuff.service.impl;

import com.socioPuff.dto.UserLogin;
import com.socioPuff.dto.UserRegistrationDto;
import com.socioPuff.entity.User;
import com.socioPuff.repo.UserRepo;
import com.socioPuff.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

/***
 * This class contains all business details for User Login Management
 * like for Influencer and Brand User Type
 */
@Service
public class UserServiceImpl implements UserService {

        private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class.getName());

        @Autowired
        private UserRepo userRepo ;

    /***
     * This method first check if user is registered or not if not then register
     * @param userRegistrationDto
     * @return dbUser
     */
    public User getRegister(UserRegistrationDto userRegistrationDto){
            LOGGER.info("Requested User Details are : " + userRegistrationDto);
            User dbUser = new User();
            User tempUser = convertUserDTOToUser(userRegistrationDto);
            if(userRepo.getUserbyEmailId(tempUser.getEmail()) == null){
               dbUser = userRepo.save(tempUser);
                LOGGER.info("User created " + dbUser);
            }

            return dbUser ;
        }

    /***
     *  This method login into SocioPuff system
     * @param user
     * @return
     */
    public User getLogin(UserLogin user){
            LOGGER.info("Login Request with user Details are : " + user);
            User dbUser = userRepo.getUserbyEmailId(user.getEmail());
            byte[] decodedBytes = Base64.getDecoder().decode(dbUser.getPassword());
            dbUser.setPassword(new String(decodedBytes));
            LOGGER.info("User feteched with detail are " + dbUser);
            return dbUser ;

        }

        private User convertUserDTOToUser(UserRegistrationDto userRegistrationDto){
            User user = new User();
            user.setEmail(userRegistrationDto.getEmail());
            user.setRole(userRegistrationDto.getRole());
            user.setMobile(userRegistrationDto.getMobile());
            user.setPassword(Base64.getEncoder().encodeToString(userRegistrationDto.getPassword().getBytes()));
            user.setRole(userRegistrationDto.getRole());
            user.setIsLogin(userRegistrationDto.getIsLogin());
            return user;

        }
}
