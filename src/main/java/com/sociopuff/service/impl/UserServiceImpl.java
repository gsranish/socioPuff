package com.sociopuff.service.impl;

import com.sociopuff.dto.UserLogin;
import com.sociopuff.dto.UserRegistrationDto;
import com.sociopuff.entity.User;
import com.sociopuff.mail.service.EmailService;
import com.sociopuff.repo.UserRepo;
import com.sociopuff.service.UserService;
import com.sociopuff.util.SocioUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        @Autowired
        private EmailService emailService;

    /***
     * This method first check if user is registered or not if not then register
     * @param userRegistrationDto
     * @return dbUser
     */
    public User getRegister(UserRegistrationDto userRegistrationDto){
            LOGGER.info("Requested User Details at getRegister method are : " + userRegistrationDto);
            User dbUser = null ;
            if(userRepo.getUserbyEmailId(userRegistrationDto.getEmail()) == null){
               dbUser = userRepo.save(convertUserDTOToUser(userRegistrationDto));
                LOGGER.info("User created Successfully " + dbUser);
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
            userRepo.setLogout(true,dbUser.getEmail());
            String decodedPassword = new String(Base64.getDecoder().decode(dbUser.getPassword()));
            dbUser.setPassword(decodedPassword);
            LOGGER.info("User fetched with detail are : " + dbUser);
            return dbUser ;

        }

    @Override
    public UserLogin getLogout(UserLogin user) {
        if(Boolean.TRUE.equals(user.getIsLogin())){
            user.setIsLogin(false);
            userRepo.setLogout(false,user.getEmail());
        }
        return user;
    }

    @Override
    public User forgetPassword(UserLogin userLogin) {
        LOGGER.info("forgetPassword with user Details are : " + userLogin);
        User dbUser = userRepo.getUserbyEmailId(userLogin.getEmail());
        Integer otp = SocioUtil.getUniqueNumber();
        userRepo.setOTP(otp,dbUser.getEmail());
        //send otp to email for validation
        String body =" Hi ! \n YOUR OTP IS " + otp;
        emailService.sendEmail(userLogin.getEmail(),body);
        return dbUser;
    }


    private User convertUserDTOToUser(UserRegistrationDto userRegistrationDto){
            User user = new User();
            user.setEmail(userRegistrationDto.getEmail());
            user.setRole(userRegistrationDto.getRole());
            user.setMobile(userRegistrationDto.getMobile());
            user.setPassword(Base64.getEncoder().encodeToString(userRegistrationDto.getPassword().getBytes()));
            user.setRole(userRegistrationDto.getRole());
            if(Boolean.FALSE.equals(userRegistrationDto.getIsLogin())){
                user.setIsLogin(userRegistrationDto.getIsLogin());
            } else {
                user.setIsLogin(false);
            }
            user.setCreatedDate(LocalDate.now());
            return user;
        }
}
