package kr.legossol.api.review.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import kr.legossol.api.review.domain.dto.ReviewFileDto;
import kr.legossol.api.review.service.ReviewFileServiceImpl;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/review_files")
@CrossOrigin(origins = "*")
public class ReviewFileController {

    private final ReviewFileServiceImpl service;


    @PostMapping("/upload_file")
    public ResponseEntity<List<ReviewFileDto>> uploadFile(List<MultipartFile> files){
        for(MultipartFile file : files){
            System.out.println("file" + file);
            if(!file.getContentType().startsWith("image")){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }
        return ResponseEntity.ok(service.saveFile(files));
    }

    @Value("${philo.arte.upload.path}")
    private String uploadPath;

    @GetMapping("/display/{fileName}")
    public ResponseEntity<byte[]> getFile(@PathVariable("fileName") String fileName){
        ResponseEntity<byte[]> result = null;
        try{
            String srcFileName = URLDecoder.decode(fileName, "UTF-8");
            log.info("fileName :" + srcFileName);
            File file = new File(uploadPath + File.separator+srcFileName);
            log.info("file : " + file);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", Files.probeContentType(file.toPath()));
            result = ResponseEntity.ok(FileCopyUtils.copyToByteArray(file));

        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return result;
    }

    @PutMapping("/update_file/{reviewFileId")
    public ResponseEntity<ArrayList<ReviewFileDto>> updateFile(List<MultipartFile> files){
        return ResponseEntity.ok(service.saveFile(files));
    }

    @DeleteMapping("/delete_file/{reviewFileId}")
    public ResponseEntity<String> deleteFile(@PathVariable("reviewFileId") Long reviewFileId){

        service.reviewFileDelete(reviewFileId);

        return ResponseEntity.ok("delete success");
    }
}
