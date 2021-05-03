package kr.legossol.api.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import kr.legossol.api.user.domain.UserDto;
import kr.legossol.api.user.domain.UserVo;
import kr.legossol.api.user.service.UserService;
import kr.legossol.api.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Api(tags="users") @RequiredArgsConstructor
@RestController @RequestMapping("/users")
public class UserController {
    private UserServiceImpl userService;
    @PostMapping("/signup") 
    @ApiOperation(value="${UserController.signin}")
    @ApiResponse(value={@ApiResponse(code=400, message = "Something went wrong"),
        @ApiResponse(code=422, message = "Access Denied"),
        @ApiResponse(code=422, message="Username is already in use")})
    public ResponseEntity<Long> signup(@ApiParam("Signup User")@RequestBody UserDto user){
        return ResponseEntity.ok(userService.signup());
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