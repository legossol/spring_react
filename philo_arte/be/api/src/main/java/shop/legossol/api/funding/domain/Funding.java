package shop.legossol.api.funding.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "fundings")
public class Funding {
    @Id
    @GeneratedValue
    @Column(name = "fundings_id")
    private Long fundingId;
}
