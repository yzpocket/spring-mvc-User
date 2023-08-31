package com.example.sparta.controller;

import com.example.sparta.dto.UserResponseDto;
import com.example.sparta.service.UserService;
import lombok.RequiredArgsConstructor;
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

    /**
     * 한 회원의 userId가 주었을때 회원 정보를 조회하는 API
     * @param id
     */
    //@GetMapping("/user/{id}")
    //public UserResponseDto getUserInfo(@PathVariable Long id) {
    //    (구현)
    //}


}