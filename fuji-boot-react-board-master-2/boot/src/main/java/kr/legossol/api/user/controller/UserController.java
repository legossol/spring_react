package kr.legossol.api.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.legossol.api.user.domain.UserVo;

@RestController @RequestMapping("/users")
public class UserController {
    @PostMapping("")
    public ResponseEntity<Long> join(@RequestBody UserVo user){
        return ResponseEntity.ok(null);
    }
    @GetMapping("")
    public ResponseEntity<List<UserVo>> fetch(@RequestBody UserVo user){
        return ResponseEntity.ok(null);
    }
    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody UserVo user){
        return ResponseEntity.ok(null);
    }
    @DeleteMapping("")
    public ResponseEntity<Long> delete(@RequestBody UserVo user){
        return ResponseEntity.ok(null);
    }
}