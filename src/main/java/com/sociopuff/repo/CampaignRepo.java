package com.sociopuff.repo;

import com.sociopuff.entity.Campaign;
import com.sociopuff.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CampaignRepo extends JpaRepository<Campaign, Integer> {
        @Query(value = "select u from User u where u.email = :email")
        User getAllCampaignBybrand( String email );
}
