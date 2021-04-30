package kr.legossol.api.bugs.controller;
import kr.legossol.api.bugs.service.BugsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bugs")
public class BugsController {

    private final BugsService service;

    @GetMapping("/{category}/scrap")
    public ResponseEntity<Long> crawlingBugs
            (@PathVariable String category) throws IOException {
        service.saveAll(category);
        System.out.println("+++++++++++ 카테고리 = " + category);

        return ResponseEntity.ok(service.saveAll(category));
    }
}