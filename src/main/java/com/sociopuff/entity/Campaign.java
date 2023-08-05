package com.sociopuff.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "table_campaign")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String campaign_name;
    private String brand_name;
    private String brand_details;
    private String product_details;
    private String content_creation_guideline;
    private String socialmedia_description;
    private String tags;
    private String preview_path;
    private Boolean is_active ;
    private String genre ;
    private String country ;
    private String age ;
    private String gender ;
    private Integer budget_upto;
    private Integer minimum_creator_size;
    private String social_media ;
    private Integer brand_id;
    private String campaign_type;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date created;
    // private LocalDate modifiedDate;
}
