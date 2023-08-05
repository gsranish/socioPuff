package com.sociopuff.controller;

import com.sociopuff.constant.MessageConstant;
import com.sociopuff.dto.Message;
import com.sociopuff.dto.UserLogin;
import com.sociopuff.dto.UserRegistrationDto;
import com.sociopuff.entity.User;
import com.sociopuff.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/***
 * This class works as a front controller which routes our request to particular endpoints
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService ;

    @GetMapping("/test")
    public ResponseEntity<Message> getMessage(){
        return new ResponseEntity<>( new Message(MessageConstant.SUCCESS,"SocioPuff"), HttpStatus.OK);
    }

    /***
     * This api is used for register user details
     * @param user type of UserRegistrationDto
     * @return type of ResponseEntity<Message>
     */
    @PostMapping("/register")
    public ResponseEntity<Message> getRegister( @RequestBody UserRegistrationDto user){
        ResponseEntity<Message> response;
        try {
            User tempuser = userService.getRegister(user);
            if(tempuser != null) {
                response = new ResponseEntity<>(new Message(MessageConstant.SUCCESS, tempuser.getEmail()), HttpStatus.CREATED);
            } else {
                response = new ResponseEntity<>(new Message(MessageConstant.FAIL," Unable to Register | duplicate Entry !"),HttpStatus.BAD_REQUEST);
            }
        } catch(Exception e) {
            response = new ResponseEntity<>(new Message(MessageConstant.FAIL," INTERNAL SERVER ERROR !"),HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return response ;
    }


    /***
     * This api is used for login Api.
     * @param user type of UserLogin
     * @return type of ResponseEntity<Message>
     */
    @PostMapping("/login")
    public ResponseEntity<Message> getLogin( @RequestBody UserLogin user){
        ResponseEntity<Message> response = null ;
        try {
            User tempUser = userService.getLogin(user);
            if(Boolean.TRUE.equals(user.getIsLogin())) {
                if (user.getEmail().equalsIgnoreCase(tempUser.getEmail()) && user.getPassword().equalsIgnoreCase(tempUser.getPassword())) {
                    response = new ResponseEntity<>(new Message(MessageConstant.SUCCESS, tempUser.getEmail()), HttpStatus.ACCEPTED);
                } else {
                    response = new ResponseEntity<>(new Message("FAILED ! Password was Incorrect ", tempUser.getEmail()), HttpStatus.ACCEPTED);
                }
            }
        } catch(Exception e) {
            response = new ResponseEntity<>(new Message(MessageConstant.FAIL, " Unable to Login"), HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return response ;
    }

    /***
     * This api is used for logout Api.
     * @param user type of UserLogin
     * @return type of ResponseEntity<Message>
     */
    @PostMapping("/logout")
    public ResponseEntity<Message> getLogout( @RequestBody UserLogin user){
        ResponseEntity<Message> response = null ;
        try {
            UserLogin tempUser = userService.getLogout(user);
            if(Boolean.TRUE.equals(user.getIsLogin())) {
                if (user.getEmail().equalsIgnoreCase(tempUser.getEmail()) && user.getPassword().equalsIgnoreCase(tempUser.getPassword())) {
                    response = new ResponseEntity<>(new Message(MessageConstant.SUCCESS, tempUser.getEmail()), HttpStatus.ACCEPTED);
                } else {
                    response = new ResponseEntity<>(new Message("FAILED ! Password was Incorrect ", tempUser.getEmail()), HttpStatus.ACCEPTED);
                }
            }
        } catch(Exception e) {
            response = new ResponseEntity<>(new Message(MessageConstant.FAIL, " Unable to Login"), HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return response ;
    }

    /***
     * This api is used for forget password Api.
     * @param user type of UserLogin
     * @return type of ResponseEntity<Message>
     */
    @PostMapping("/forget")
    public ResponseEntity<Message> forgetPassword( @RequestBody UserLogin user){
        ResponseEntity<Message> response = null;
        try {
            User tempUser = userService.forgetPassword(user);
            if(user.getIsLogin()) {
                if (user.getEmail().equalsIgnoreCase(tempUser.getEmail()) && user.getPassword().equalsIgnoreCase(tempUser.getPassword())) {
                    response = new ResponseEntity<>(new Message(MessageConstant.SUCCESS, tempUser.getEmail()), HttpStatus.ACCEPTED);
                } else {
                    response = new ResponseEntity<>(new Message("FAILED ! Password was Incorrect ", tempUser.getEmail()), HttpStatus.ACCEPTED);
                }
            }
        } catch(Exception e) {
            response = new ResponseEntity<>(new Message(MessageConstant.FAIL," Unable to Reset Password"),HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return response ;
    }
}
