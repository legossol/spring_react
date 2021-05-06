package com.example.demo.its.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "file")
public class ItemFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fileNo;
    @Column(nullable = false)
    private String ofname;
    @Column(nullable = false)
    private String sfname;
    @Column(nullable = false)
    private long fsize;
    @Column(nullable = false)
    private String filePath;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_no")
    private SaleItem SaleItem;

    @Builder
    public ItemFile(long fileNo, String ofname, String sfname, long fsize) {
        this.fileNo = fileNo;
        this.ofname = ofname;
        this.sfname = sfname;
        this.fsize = fsize;

    }

}
