package com.example.sparta.service;

import com.example.sparta.dto.UserResponseDto;
import com.example.sparta.repository.UserRepository;
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
    public UserResponseDto findUser(Long id) {
        // DB 조회
        UserRepository memoRepository = new UserRepository(jdbcTemplate);
        return memoRepository.findUserById(id);
    }
}