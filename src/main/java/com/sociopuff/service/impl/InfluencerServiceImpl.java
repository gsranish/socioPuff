package com.sociopuff.service.impl;

import com.sociopuff.entity.Influencer;
import com.sociopuff.repo.InfluencerRepo;
import com.sociopuff.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InfluencerServiceImpl implements InfluencerService {

    @Autowired
    private InfluencerRepo influencerRepo ;

    @Override
    public List<Influencer> getAllInfluencers() {
        List<Influencer> campaignList = null ;
        try {
            campaignList = influencerRepo.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return campaignList;
    }

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        Influencer dbInfluencer = null ;
        try {
             dbInfluencer = influencerRepo.save(influencer);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return dbInfluencer;
    }

    @Override
    public Influencer editInfluencer(Influencer influencer) {
        Influencer dbInfluencer = null ;
        try {
             dbInfluencer = influencerRepo.saveAndFlush(influencer);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return dbInfluencer;
    }

    @Override
    public Integer deleteInfluencer(Integer influencerId) {
        try {
            influencerRepo.deleteById(influencerId);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return influencerId;
    }
}
