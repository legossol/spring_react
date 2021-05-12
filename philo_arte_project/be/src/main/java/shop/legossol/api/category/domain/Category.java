package shop.jinwookoh.api.category.domain;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private long categoryId;
    @Column
    private long name;
}