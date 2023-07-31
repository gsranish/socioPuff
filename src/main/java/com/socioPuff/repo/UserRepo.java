package com.socioPuff.repo;

import com.socioPuff.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.email = :email")
    User getUserbyEmailId(@Param("email") String email );

}
