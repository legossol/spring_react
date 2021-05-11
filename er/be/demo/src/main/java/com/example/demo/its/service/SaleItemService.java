package com.example.demo.its.service;

import java.util.List;

import com.example.demo.its.domain.SaleItem;
public interface SaleItemService {

    public SaleItem findByItemNo(Long id);

    public List<SaleItem> findAllByOrderByItemNo();

}
