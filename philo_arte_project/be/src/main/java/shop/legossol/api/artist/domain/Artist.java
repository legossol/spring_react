package shop.jinwookoh.api.artist.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "artists")
@Data
@NoArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private long artistId;
    @Column(unique = true, nullable = false)
    private String username;
    @Size(min=8, message = "Minimum Passsword Length: 8 characters")
    private String password;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "affiliation")
    private String affiliation;
    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;
}