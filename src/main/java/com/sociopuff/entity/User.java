package com.sociopuff.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Size(max = 50)
        @Email
        private String email;

        @Size(min = 10)
        private String mobile;

        private Integer otp;

        @Size(max = 50)
        private String role ;

        private String password ;

        private Boolean isLogin ;

        private LocalDate createdDate;

        private LocalDate modifiedDate;


}
