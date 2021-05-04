package kr.legossol.api.user.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;

@Data @Table(name="users")
public class UserVo {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)Long userId;
    @Column(name = "username")private String username;
    @Size(min=8, message = "Minimum password Length : 8 Characters") private String password;
    @Column(name = "email")private String email;
	@Column(name = "user_name")private String userName;	
	@Column(name = "age")private String age;
	@Column(name = "birthday")private String birthday;	
	@Column(name = "gender")private String gender;	
	@CreationTimestamp
    @Column(name = "date")private LocalDateTime date;
    @Column(name = "phone")private String phone;

    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;

    @Builder
    public UserVo(Long userId, String username, String password, String userName, String age,String email, String birthday,String gender, String phone,Long userno,LocalDateTime date){
        super();
		this.username = username;
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
