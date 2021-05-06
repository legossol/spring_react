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
    @GeneratedValue(strategy=GenerationType.IDENTITY)private Long userId;
    @Column(unique = true, nullable = false) private String username;
    @Size(min=8, message = "Minimum Password Length: 8 characters") private String password;
    @Column(unique = true, nullable = false) private String email;
    @Column(unique = true, nullable = false) private String name;
    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;
}

