package com.sociopuff.repo;

import com.sociopuff.entity.Influencer;
import com.sociopuff.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InfluencerRepo extends JpaRepository<Influencer, Integer> {



}
