package com.sociopuff.controller;

import com.google.gson.Gson;
import com.sociopuff.constant.MessageConstant;
import com.sociopuff.dto.Message;
import com.sociopuff.entity.Influencer;
import com.sociopuff.repo.InfluencerRepo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/influencer")
@CrossOrigin(origins = "*")
public class InfluencerController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(InfluencerController.class);
    @Autowired
    private InfluencerRepo influencerRepo ;

    @GetMapping("/all")
    public ResponseEntity<Message> getAllInfluencers() {
        ResponseEntity<Message> response;
        try {
            List<Influencer> campaignList = influencerRepo.findAll();
            Gson gson = new Gson();
            String jsonCartList = gson.toJson(campaignList);
            logger.info(jsonCartList);
            if (campaignList.isEmpty()) {
                response = new ResponseEntity<>(new Message(MessageConstant.FAIL, "No Data Available"), HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(new Message(MessageConstant.SUCCESS, jsonCartList), HttpStatus.OK);
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(new Message(MessageConstant.FAIL, "Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/save")
    public ResponseEntity<Message> createInfluencer(@RequestBody Influencer influencer){
        ResponseEntity<Message> response = null ;
        try {
            Influencer id = influencerRepo.save(influencer);
            response = new ResponseEntity<>(new Message(MessageConstant.SUCCESS, id.getInfluencer_name()), HttpStatus.OK);
        } catch (Exception e){
            response = new ResponseEntity<Message>(new Message("FAIL"," Unable to Save"),HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/edit")
    public ResponseEntity<Message> editInfluencer(@RequestBody Influencer influencer){
        ResponseEntity<Message> response = null ;
        try {
            Influencer id = influencerRepo.saveAndFlush(influencer);
            response = new ResponseEntity<>(new Message(MessageConstant.SUCCESS, id.getInfluencer_name()), HttpStatus.OK);
        } catch (Exception e){
            response = new ResponseEntity<Message>(new Message("FAIL"," Unable to Save"),HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return response;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Message> deleteInfluencer(@RequestBody Integer influencerId){
        ResponseEntity<Message> response = null ;
        try {
            influencerRepo.deleteById(influencerId);
            response = new ResponseEntity<>(new Message(MessageConstant.SUCCESS, "Deleted"), HttpStatus.OK);
        } catch (Exception exception){
            response = new ResponseEntity<Message>(new Message("FAIL"," Unable to Save"),HttpStatus.BAD_REQUEST);
            exception.printStackTrace();
        }
        return response;
    }
}
