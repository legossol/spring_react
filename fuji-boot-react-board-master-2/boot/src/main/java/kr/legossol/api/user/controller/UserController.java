package kr.legossol.api.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jdk.internal.org.jline.utils.Log;
import kr.legossol.api.user.domain.UserVo;

@log
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
    @GetMapping("/all")
    public ResponseEntity<List<UserVo>> all(){
        Log.info("로그인 하지 않은 사용자도 접근가능한 URI");
        return ResponseEntity.ok(null);
    }
    @PostMapping("/{username}")
    public ResponseEntity<?> auth(@PathVariable String username){
        Log.info("로그인한 사용자도 접근가능한 URI");
        return ResponseEntity.ok(null);
    }
    @PostMapping("/admin")
    public ResponseEntity<?> admin(){
        Log.info("관리자만 접근가능한 URI");
        return ResponseEntity.ok(null);
    }
}