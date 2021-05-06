package com.example.demo.its.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.its.domain.ItemFile;
import com.example.demo.its.domain.SaleItem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface SaleItemService {

    public SaleItem findByItemNo(Long id);

    public List<SaleItem> findAllByOrderByItemNo();

}
