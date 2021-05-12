package shop.jinwookoh.api.user.controller;

import shop.jinwookoh.api.user.domain.UserVo;
import shop.jinwookoh.api.user.domain.UserDto;
import shop.jinwookoh.api.user.service.UserServiceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RestController
@Api(tags = "users")
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Log
public class UserController {

    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<UserVo>> fetch() {

        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/signup")
    @ApiOperation(value = "${userController.signup}")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access Denied"),
            @ApiResponse(code = 422, message = "Username is already in use") })
    public ResponseEntity<String> signup(@ApiParam("Signup user") @RequestBody UserDto user) {
        return ResponseEntity.ok(userService.signup(modelMapper.map(user, UserVo.class)));
    }

    @PostMapping("/signin")
    @ApiOperation(value = "${userController.signin}")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access Denied"),
            @ApiResponse(code = 422, message = "Invalid Username / Password supplied") })
    public ResponseEntity<UserDto> signin(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.signin(modelMapper.map(user, UserVo.class)));
    }

    @PutMapping(value = "")
    public ResponseEntity<Long> update(@RequestBody UserDto user) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "")
    public ResponseEntity<Long> delete(@RequestBody UserDto user) {
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDto>> all(@RequestBody UserDto user) {
        log.info("로그인 안한 사용자도 접근 가능");
        return ResponseEntity.ok(null);
    }

    @PostMapping(value = "/{username}")
    public ResponseEntity<?> auth(@RequestBody String username) {
        log.info("로그인 한 사용자가 접근 가능");
        return ResponseEntity.ok(null);
    }

    // 관리자
    @PostMapping(value = "/admin")
    public ResponseEntity<?> admin(@RequestBody String username) {
        log.info("관리자 로그인 ");
        return ResponseEntity.ok(null);
    }

}
