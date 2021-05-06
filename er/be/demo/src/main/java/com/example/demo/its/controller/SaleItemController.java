package com.example.demo.its.controller;

import com.amazonaws.services.opsworkscm.model.Server;
import com.amazonaws.services.xray.model.Http;
import com.example.demo.its.domain.SaleItem;
import com.example.demo.its.domain.SaleItemDto;
import com.example.demo.its.service.SaleItemServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/saleItems")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class SaleItemController {

    private final SaleItemServiceImpl service;

    // @PostMapping("/register")
    // public ResponseEntity<String> save(@RequestBody SaleItem item) {
    // System.out.println("postRegister()");
    // service.save(item);
    // return new ResponseEntity<>(HttpStatus.OK);
    // }

    @GetMapping("/list")
    public ResponseEntity<List<SaleItem>> list() {
        System.out.println("getList()");

        return new ResponseEntity<>(service.findAllByOrderByItemNo(), HttpStatus.OK);
    }

    @GetMapping("/{itemNo}")
    public ResponseEntity<SaleItem> detail(@PathVariable("itemNo") Long itemNo) {
        System.out.println("getDetail()");
        SaleItem si = service.findByItemNo(itemNo);
        return new ResponseEntity<>(si, HttpStatus.OK);
    }

    // @PostMapping(value = "/{itemNo}")
    // public ResponseEntity<SaleItem> modify(@PathVariable("itemNo") Long itemNo,
    // @RequestBody SaleItem item) {
    // System.out.println("PutModify(): " + item);
    // item.getItemNo();
    // service.save(item);

    // return new ResponseEntity<>(item, HttpStatus.OK);
    // }

    @DeleteMapping(value = "/{itemNo}")
    public ResponseEntity<Void> remove(@PathVariable("itemNo") Long itemNo) {
        System.out.println("DeleteRemove() itemNO: " + itemNo);
        service.deleteById(itemNo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
