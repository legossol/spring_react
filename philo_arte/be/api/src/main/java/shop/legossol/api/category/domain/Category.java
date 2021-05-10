package shop.legossol.api.category.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cateegory")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long categoryId;
    
}
