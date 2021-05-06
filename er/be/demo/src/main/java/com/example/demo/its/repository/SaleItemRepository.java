package com.example.demo.its.repository;

import java.util.List;

import com.example.demo.its.domain.SaleItem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

interface SaleItemCustomRepository {

    @Query(value = "SELECT * FROM SaleItem GROUP BY soldOut", nativeQuery = true)
    public List<SaleItem> groupListBySoldOut(boolean soldOut);

    public List<SaleItem> findAllByOrderByItemNo();

    public SaleItem findByItemNo(@Param("itemNo") long itemNo);
}

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long>, SaleItemCustomRepository {

    public SaleItem findByHashTag(String hashTag);

}
