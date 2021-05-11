package shop.jinwookoh.api.work.dmain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import shop.jinwookoh.api.category.domain.Category;
import shop.jinwookoh.api.user.domain.UserVo;

@Data
@Entity
@Table(name = "works")
public class Work {
    @Id
    @GeneratedValue
    @Column(name = "work_id")
    private long workId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private long description;
    @Column(name = "reg_date")
    private long regDate;
    @Column(name = "edit_date")
    private long editDate;
    @Column(name = "main_img")
    private long mainImg;

    // @ManyToOne
    // @JoinColumn(name = "category_id")
    // List<Category> categories;

    // @ManyToOne
    // @JoinColumn(name = "user_id")
    // List<UserVo> users;

}
