package com.example.demo.campaign.domain.article;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.campaign.domain.participant.Participant;

@Entity
public class Campaign {

    @Id
    @GeneratedValue
    @Column(name = "campaign_id")
    private long campaignId;

}
