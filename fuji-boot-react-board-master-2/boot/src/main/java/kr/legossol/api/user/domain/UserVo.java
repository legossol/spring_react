package kr.legossol.api.user.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;

@Entity @Table(name="users")
public class UserVo {
    @Id
    @Column(name="user_id")Long userId;
    @Column(name = "name")private String name;
	@Column(name = "password")private String password;
	@Column(name = "user_name")private String userName;	
	@Column(name = "age")private String age;
	@Column(name = "email")private String email;	
	@Column(name = "birthday")private String birthday;	
	@Column(name = "gender")private String gender;	
	@CreationTimestamp
    @Column(name = "date")private LocalDateTime date;
    @Column(name = "phone")private String phone;

    @Builder
    public UserVo(Long userId, String name, String password, String userName, String age,String email, String birthday,String gender, String phone,Long userno,LocalDateTime date){
        super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.userId = userId;
		this.date = date;
    }

}
