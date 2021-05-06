package com.example.demo.its.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.cmm.service.AbstractService;
import com.example.demo.cmm.util.Path;
import com.example.demo.its.domain.ItemFile;
import com.example.demo.its.domain.SaleItem;
import com.example.demo.its.repository.FileRepository;
import com.example.demo.its.repository.SaleItemRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Service
@Log
@RequiredArgsConstructor
public class SaleItemServiceImpl extends AbstractService<SaleItem> implements SaleItemService {

    private final SaleItemRepository repo;

    @Override
    public SaleItem findByItemNo(Long id) {
        // TODO Auto-generated method stub
        return repo.findByItemNo(id);
    }

    @Override
    public List<SaleItem> findAllByOrderByItemNo() {
        // TODO Auto-generated method stub
        return repo.findAllByOrderByItemNo();
    }

    @Override
    public Long save(SaleItem t) {
        // TODO Auto-generated method stub
        return (repo.save(t) != null) ? 1L : 0L;
    }

    @Override
    public Optional<SaleItem> findById(long id) {
        // TODO Auto-generated method stub
        return repo.findById(id);
    }

    @Override
    public List<SaleItem> findAll() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return repo.count();
    }

    @Override
    public Optional<SaleItem> getOne(long id) {
        // TODO Auto-generated method stub

        return Optional.of(repo.getOne(id));
    }

    @Override
    public Long delete(SaleItem t) {
        // TODO Auto-generated method stub
        repo.delete(t);
        return 0L;
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        repo.deleteAll();

    }

    @Override
    public Boolean existsById(long id) {
        // TODO Auto-generated method stub
        return repo.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }

}