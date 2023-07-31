package com.socioPuff.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Size(max = 50)
        @Email
        private String email;

        @Size(min = 10)
        private String mobile;

        @Size(max = 50)
        private String role ;

        private String password ;

        private Boolean isLogin ;


}
