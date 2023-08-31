package com.example.sparta.controller;

import com.example.sparta.dto.UserResponseDto;
import com.example.sparta.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final JdbcTemplate jdbcTemplate;
    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 회원의 전체 목록을 조회하는 API
     */
    @GetMapping("/user")
    public List<UserResponseDto> getUserList() {
        UserService userService = new UserService(jdbcTemplate);
        return userService.findAllUser();
    }

    /*
     * 한 회원의 userId가 주었을때 회원 정보를 조회하는 API
     * @param id
     */
    @GetMapping("/user/{id}")
    public UserResponseDto getUserInfo(@PathVariable Long id) {
        UserService userService = new UserService(jdbcTemplate);
        return userService.findUser(id);
        //예외처리는 가장 낮은 계층인 Service>Repository에서 처리해서 여기서 또 할필요가 없다. 중복처리하지 않도록 조심.
        //if (user != null) {
        //    return user;
        //} else {
        //    // 사용자를 찾을 수 없는 경우 404 에러 반환
        //    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다.");
        //}
    }
}