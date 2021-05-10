package shop.legossol.api.fundItem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "fund_items")
public class funding {
    @Id
    @GeneratedValue
    @Column(name = "funditem_id")
    private Long funditemId;
}
