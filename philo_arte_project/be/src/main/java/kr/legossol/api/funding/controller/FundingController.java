package kr.legossol.api.funding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import kr.legossol.api.common.util.ModelMapperUtils;
import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;
import kr.legossol.api.funding.domain.FundingFileDto;
import kr.legossol.api.funding.service.FundingServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Log4j2

@RestController
@RequiredArgsConstructor
@Api(tags = "funding")
@RequestMapping("/funding")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class FundingController {
    private final FundingServiceImpl service;

    @GetMapping("/list")
    public ResponseEntity<List<Funding>> list(){
        System.out.println("아이템리스트 진입");
        return ResponseEntity.ok(service.getAllFundings());
        //     service.findAll().stream()
        // .map(funding -> ModelMapperUtils.getModelMapper().map(funding, FundingDto.class)).collect(Collectors.toList()));
    }
    @GetMapping("/list/{fundingId}")
    public ResponseEntity<FundingDto> getOneFundingById(@PathVariable("fundingId") Long fundingId){
       
        return ResponseEntity.ok(service.getFundingById(fundingId));
    }
    @PostMapping("/register")
    public ResponseEntity<String> save(@RequestBody FundingDto dto){
        System.out.println("아이템 등록진입");
        
        return ResponseEntity.ok("등록을 성공했습니다."+service.save(dto));
    }
    @PutMapping("/edit/{fundingId}")
    public ResponseEntity<String> updateFunding(@PathVariable("fundingId") Long fundingId, @RequestBody FundingDto fundingdto){
    if(service.findById(fundingId).isEmpty()){
        log.info("해당 글이 조회되지 않습니다.");
        ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.save(fundingdto));
    }   
    @DeleteMapping("/{fundingId}")
    public ResponseEntity<String> deleteFunding(@PathVariable("fundingId")Long fundingId, @RequestBody FundingDto fundingdto){
        
        service.deleteById(fundingId);
        return ResponseEntity.ok("식제 성공");
    }
}

