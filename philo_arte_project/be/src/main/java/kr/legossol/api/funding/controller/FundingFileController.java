package kr.legossol.api.funding.controller;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.legossol.api.funding.domain.FundingDto;
import kr.legossol.api.funding.domain.FundingFileDto;
import kr.legossol.api.funding.service.FundingServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/funding_file")
@CrossOrigin(origins = "*")
public class FundingFileController {
    private final FundingServiceImpl service;
    @PostMapping("/sum")
    public ResponseEntity<Long> sumRegister(FundingDto dto){
        Long fundingId = service.textAndPicSave(dto);
        return  ResponseEntity.ok(fundingId);
    }
    @PostMapping("/upload_file")
    public ResponseEntity<List<FundingFileDto>> uploadFile(List<MultipartFile> files) {
        return ResponseEntity.ok(service.registerFile(
            files.stream().filter(f->f.getContentType().startsWith("image")).collect(Collectors.toList())));
        
    }

    @Value("${shop.legossol.upload.path}")
    private String uploadPath;

    @GetMapping("/display/{fileName}")
    public ResponseEntity<byte[]> getFile(@PathVariable("fileName") String fileName) {
        ResponseEntity<byte[]> result = null;
        try {
            String srcFileName = URLDecoder.decode(fileName, "UTF-8");
            log.info("fiilName: " + srcFileName);
            File file = new File(uploadPath + File.separator + srcFileName);
            log.info("file: " + file);
            HttpHeaders header = new HttpHeaders();
            header.add("Content-Type", Files.probeContentType(file.toPath()));
            result = ResponseEntity.ok(FileCopyUtils.copyToByteArray(file));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return result;
    }

    @DeleteMapping(value = "/delete_file/{fundingFileId}")
    public ResponseEntity<String> deleteFile(@PathVariable("fundingFileId") Long id) {

        return ResponseEntity.ok(service.deleteFile(id));
    }
}
