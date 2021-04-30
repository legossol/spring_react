package kr.legossol.api.bugs.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Bugs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bugsId;

    @Column(length = 20, nullable = false)
    private String bugsNo;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 512, nullable = false)
    private String title;

    @Column(length = 1024, nullable = false)
    private String address;

    @Builder
    public Bugs(String bugsNo, String category,
                String title, String address) {
        this.bugsNo = bugsNo;
        this.address = address;
        this.category = category;
        this.title = title;
    }
}