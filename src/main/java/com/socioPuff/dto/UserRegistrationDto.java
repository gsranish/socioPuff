package com.socioPuff.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/***
 * This class is for Registration Purpose i.e, for register payload
 */
@Data
public class UserRegistrationDto {

    private String firstName;

    private String lastName;

    @NotEmpty
    private String password;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String mobile;

    @NotEmpty
    private String role;

    private Boolean terms;

    private Boolean isLogin ;

}
