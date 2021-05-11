package com.example.demo.campaign.domain.participant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "participants")
public class Participant {

     @Id
     @GeneratedValue
     @Column(name = "participant_no")
     private long participantNo;

     @Column(name = "name")
     private String name;

     @Column(name = "gender")
     private String gender;

     @Column(name = "phone_number")
     private String phoneNumber;

     @Column(name = "email")
     private String email;

     @Column(name = "birthday")
     private String birthday;

     @Column(name = "reg_date")
     private String regdate;

}