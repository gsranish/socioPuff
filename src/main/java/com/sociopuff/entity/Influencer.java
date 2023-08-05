package com.sociopuff.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "table_influencer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String influencer_name;
    private String  pwd;
    private Date created;
    private String  email_id;
    private String  country;
    private String  mobile;
    private Boolean is_active  ;
    private Boolean panel_login  ;
    private String  instagram;
    private String  youtube;
    private String  tiktok;
    private String  twitter;
    private String  facebook;
    private String  blogger;
    private String  other;
    private String  age;
    private String  gender;
    private String  address;
    private String  tags;
    private String  follower_range;
    private String  influencer_lastname;
    private String  city;
    private String  state;
    private Integer  pincode;
    private String  address2;


}
