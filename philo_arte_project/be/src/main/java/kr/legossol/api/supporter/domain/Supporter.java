package kr.legossol.api.supporter.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "supporters")
@NoArgsConstructor
@Data
public class Supporter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supporter_id")
    private long supporterId;
    @Column(unique = true, nullable = false)
    private String username;
    @Size(min = 8, message = "Minimum Passsword Length: 8 characters")
    private String password;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(name = "supporter_email")
    private String supporterEmail;
    @Column(name = "supporter_number")
    private String supporterPhoneNumber;
}