package com.example.sparta.service;

import com.example.sparta.dto.UserResponseDto;
import com.example.sparta.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class UserService {

    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<UserResponseDto> findAllUser() {
        // DB 조회
        UserRepository memoRepository = new UserRepository(jdbcTemplate);
        return memoRepository.findAllUser();
    }
    //public UserResponseDto findUser((구현)) {
    //    (구현)
    //}
}