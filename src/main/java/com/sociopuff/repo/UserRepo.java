package com.sociopuff.repo;

import com.sociopuff.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.email = :email")
    User getUserbyEmailId( String email );

    @Query(value = "UPDATE User u SET u.isLogin = :isLogin WHERE u.email = :email")
    @Modifying
    @Transactional
    void setLogout(  Boolean isLogin, String email );

    @Query(value = "UPDATE User u SET u.otp = :otp WHERE u.email = :email")
    @Modifying
    @Transactional
    void setOTP( Integer otp, String email );

}
