package com.example.demo.fund.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.cmm.service.AbstractService;
import com.example.demo.fund.domain.Fund;
import com.example.demo.fund.repository.FundRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@Lazy
@RequiredArgsConstructor
public class FundServiceImpl extends AbstractService<Fund> implements FundService {

    private final FundRepository repository;

    @Override
    public Long save(Fund t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Fund> findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Fund> findAll() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Fund> getOne(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long delete(Fund t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Boolean existsById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        
    }

}
