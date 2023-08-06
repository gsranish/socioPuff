package com.sociopuff.service;

import com.sociopuff.entity.Influencer;

import java.util.List;

public interface InfluencerService {

    public List<Influencer> getAllInfluencers();

    public Influencer createInfluencer(Influencer influencer);

    public Influencer editInfluencer(Influencer influencer);

    public Integer deleteInfluencer(Integer campaignId);

}
