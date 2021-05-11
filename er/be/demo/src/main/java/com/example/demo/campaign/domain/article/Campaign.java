package com.example.demo.campaign.domain.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Campaign {

    @Id
    @GeneratedValue
    @Column(name = "campaign_id")
    private long campaignId;

}
