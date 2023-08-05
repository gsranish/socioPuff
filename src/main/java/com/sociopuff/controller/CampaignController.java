package com.sociopuff.controller;


import com.google.gson.Gson;
import com.sociopuff.constant.MessageConstant;
import com.sociopuff.dto.Message;
import com.sociopuff.entity.Campaign;
import com.sociopuff.entity.Influencer;
import com.sociopuff.repo.CampaignRepo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/campaign")
public class CampaignController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CampaignController.class);

    @Autowired
    private CampaignRepo campaignRepo ;

    @GetMapping("/all")
    public ResponseEntity<Message> getAllCampaigns(){
        ResponseEntity<Message> response;
        List<Campaign> campaignList = campaignRepo.findAll();
        Gson gson = new Gson();
        String jsonCartList = gson.toJson(campaignList);
        logger.info(jsonCartList);
        if(campaignList.isEmpty()){
            response = new ResponseEntity<>( new Message(MessageConstant.FAIL,"No Data Available"), HttpStatus.OK);
        } else {
            response = new ResponseEntity<>( new Message(MessageConstant.SUCCESS,jsonCartList), HttpStatus.OK);
        }
        return response;
    }

    @PostMapping("/save")
    public ResponseEntity<Message> createCampaign(@RequestBody Campaign campaign){
        ResponseEntity<Message> response = null ;
        try {
            campaignRepo.save(campaign);
        } catch (Exception e){
            response = new ResponseEntity<Message>(new Message("FAIL"," Unable to Save"),HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/edit")
    public ResponseEntity<Message> editCampaign(@RequestBody Campaign campaign){
        ResponseEntity<Message> response = null ;
        try {
            Campaign id = campaignRepo.saveAndFlush(campaign);
            response = new ResponseEntity<>(new Message(MessageConstant.SUCCESS, id.getCampaign_name()), HttpStatus.OK);
        } catch (Exception e){
            response = new ResponseEntity<Message>(new Message("FAIL"," Unable to Save"),HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return response;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Message> deleteCampaign(@RequestBody Integer campaignId){
        ResponseEntity<Message> response = null ;
        try {
            campaignRepo.deleteById(campaignId);
            response = new ResponseEntity<>(new Message(MessageConstant.SUCCESS, "Deleted"), HttpStatus.OK);
        } catch (Exception exception){
            response = new ResponseEntity<Message>(new Message("FAIL"," Unable to Save"),HttpStatus.BAD_REQUEST);
            exception.printStackTrace();
        }
        return response;
    }

}
