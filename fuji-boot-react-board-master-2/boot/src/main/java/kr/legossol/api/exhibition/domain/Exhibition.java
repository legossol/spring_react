package kr.legossol.api.exhibition.domain;
import kr.legossol.api.hall.domain.Hall;

import javax.persistence.*;

@Entity
@Table(name = "exhibitions")
public class Exhibition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exhibition_id") private long exhibitionId;

    @ManyToOne
    @JoinColumn()
    Hall hall;
}