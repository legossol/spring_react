package com.example.demo.its.repository;

import com.example.demo.its.domain.ItemFile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface FileCustomRepository {

}

@Repository
public interface FileRepository extends JpaRepository<ItemFile, Long>, FileCustomRepository {

}
