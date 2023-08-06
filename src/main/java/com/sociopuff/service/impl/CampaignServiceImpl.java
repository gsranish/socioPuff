package com.sociopuff.service.impl;

import com.sociopuff.entity.Campaign;
import com.sociopuff.repo.CampaignRepo;
import com.sociopuff.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignRepo campaignRepo ;
    @Override
    public List<Campaign> getAllCampaigns() {
        List<Campaign> campaignList = null ;
        try {
            campaignList = campaignRepo.findAll();
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return campaignList;
    }

    @Override
    public Campaign createCampaign(Campaign campaign) {
        try {
            Campaign dbCampaign = campaignRepo.save(campaign);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Campaign editCampaign(Campaign campaign) {
        Campaign dbCampaign = null ;
        try {
             dbCampaign = campaignRepo.saveAndFlush(campaign);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return dbCampaign;
    }

    @Override
    public Integer deleteCampaign(Integer campaignId) {
        try {
            campaignRepo.deleteById(campaignId);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return campaignId;
    }
}
