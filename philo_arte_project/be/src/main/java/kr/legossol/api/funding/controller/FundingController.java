package kr.legossol.api.funding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import kr.legossol.api.common.util.ModelMapperUtils;
import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;
import kr.legossol.api.funding.service.FundingServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@Api(tags = "funding")
@RequestMapping("/funding")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class FundingController {
    private final FundingServiceImpl service;

    // @GetMapping("/list")
    // public ResponseEntity<List<FundingDto>> list(){
    //     System.out.println("아이템리스트 진입");
    //     return ResponseEntity.ok(service.findAll().stream()
    //     .map(funding -> ModelMapperUtils.getModelMapper().map(funding, FundingDto.class)).collect(Collectors.toList()));
    // }
    // @GetMapping("/list/{fundingId}")
    // public ResponseEntity<FundingDto> getOneFundingById(@PathVariable("fundingId") Long fundingId){
    //    Funding funding = service.getOne(fundingId);

    //     Optional<FundingDto> it = service.findById(fundingId);
    //     return ResponseEntity.ok(it.get());
    // // }
    @PostMapping("/register")
    public ResponseEntity<String> save(@RequestBody FundingDto dto){
        System.out.println("아이템 등록진입");
        
        return ResponseEntity.ok("등록을 성공했습니다."+service.save(dto));
    }
    // @PutMapping("/{fundingId}")
    // public ResponseEntity<Funding> updateFunding(@PathVariable("fundingId") Long fundingId, @RequestBody Funding funding){
    // System.out.println("아이템수정 진입" + fundingId);
    
    // service.updateFunding(fundingId,funding);
    // return ResponseEntity.ok(funding);
    // }   
    // @DeleteMapping("/{fundingId}")
    // public ResponseEntity<String> deleteFunding(@PathVariable("fundingId")Long fundingId){
    //     service.deleteById(fundingId);
    //     return ResponseEntity.ok("삭제 성공");
    // }
   
    
}

