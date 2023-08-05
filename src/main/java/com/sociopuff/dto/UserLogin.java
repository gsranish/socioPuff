package com.sociopuff.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/***
 * This class contains Login Request Payload
 */
@Data
public class UserLogin {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String role ;

    private Boolean isLogin ;
}
