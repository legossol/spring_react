package shop.legossol.api.user.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
public class UserVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(unique = true, nullable = false)
    private String username;
    @Size(min = 8, message = "Minimum Password Length: 8 characters")
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "name")
    private String name;

    // 즉시 실행 와이? 접속하자마자 권한을 부여해줘야 하기 때문에
    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;

    public String getUsername() {
        return null;
    }

	public CharSequence getPassword() {
		return null;
	}

	public void setPassword(String encode) {
	}

	public void setRoles(List<Role> list) {
	}

	public List<Role> getRoles() {
		return null;
	}

}