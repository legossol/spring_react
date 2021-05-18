package kr.legossol.api.testreact.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.legossol.api.testreact.dto.PerformanceDTO;
import kr.legossol.api.testreact.entity.Performance;
import kr.legossol.api.testreact.service.PerformanceService;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/performance")
public class PerformanceController {

    private final PerformanceService performanceService;

    @PostMapping("")
    public ResponseEntity<Long> register(PerformanceDTO performanceDTO){

        log.info("register.............................");
        log.info(performanceDTO);

        Long pno = performanceService.register(performanceDTO);

        return new ResponseEntity<>(pno, HttpStatus.CREATED);
    }

}
