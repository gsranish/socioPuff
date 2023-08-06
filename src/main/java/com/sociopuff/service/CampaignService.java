package com.sociopuff.service;

import com.sociopuff.entity.Campaign;

import java.util.List;

public interface CampaignService {

    public List<Campaign> getAllCampaigns();

    public Campaign createCampaign(Campaign campaign);
    public Campaign editCampaign(Campaign campaign);
    public Integer deleteCampaign(Integer campaignId);
}
