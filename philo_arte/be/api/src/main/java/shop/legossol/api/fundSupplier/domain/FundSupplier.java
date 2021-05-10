package shop.legossol.api.fundSupplier.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "fundees")
public class FundSupplier {
    @Id
    @GeneratedValue
    @Column(name = "fundee_id")
    private Long fundeeId;
    
}
