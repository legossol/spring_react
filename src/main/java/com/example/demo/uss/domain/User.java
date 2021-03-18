package com.example.demo.uss.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity

@Table(name="users")
public class User{

	@Id
	@Column(name = "user_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userNo;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	
	@Column(name = "authority")
	private String authority;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "gender")
	private String gender;
	
	
	
}