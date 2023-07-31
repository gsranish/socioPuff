package com.socioPuff.controller;

import com.socioPuff.dto.Message;
import com.socioPuff.dto.UserLogin;
import com.socioPuff.dto.UserRegistrationDto;
import com.socioPuff.entity.User;
import com.socioPuff.service.UserService;
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

    @Autowired
    private UserService userService ;


    @GetMapping("/test")
    public ResponseEntity<Message> getMessage(){
        return new ResponseEntity<Message>(new Message("SUCCESS","SocioPuff"), HttpStatus.OK);
    }

    /***
     * This api is used for register user details
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<Message> getRegister( @RequestBody UserRegistrationDto user){
        ResponseEntity<Message> response = null ;
        try {
            User tempuser = userService.getRegister(user);
            if(tempuser != null) {
                response = new ResponseEntity<Message>(new Message("SUCCESS", tempuser.getEmail()), HttpStatus.CREATED);
            } else {
                response = new ResponseEntity<Message>(new Message("FAIL"," Unable to Register | duplicate Entry !"),HttpStatus.BAD_REQUEST);
            }

        } catch(Exception e) {
            response = new ResponseEntity<Message>(new Message("FAIL"," Unable to Register !"),HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return response ;
    }


    /***
     * This api is used for login Api.
     * @param user
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<Message> getLogin( @RequestBody UserLogin user){
        ResponseEntity<Message> response = null ;
        try {
            User tempUser = userService.getLogin(user);
            if(user.getIsLogin()) {
                if (user.getEmail().equalsIgnoreCase(tempUser.getEmail()) && user.getPassword().equalsIgnoreCase(tempUser.getPassword())) {
                    response = new ResponseEntity<Message>(new Message("SUCCESS", tempUser.getEmail()), HttpStatus.ACCEPTED);
                } else {
                    response = new ResponseEntity<Message>(new Message("FAILED ! Password was Incorrect ", tempUser.getEmail()), HttpStatus.ACCEPTED);
                }
            }
        } catch(Exception e) {
            response = new ResponseEntity<Message>(new Message("FAIL"," Unable to Login"),HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return response ;
    }
}
