package shop.legossol.api.fundSuppoorter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "funders")
public class FundSupporteer {
    @Id
    @GeneratedValue
    @Column(name = "funder_id")
    private Long funderId;
    
}
