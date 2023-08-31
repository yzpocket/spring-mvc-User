package com.example.sparta.repository;

import com.example.sparta.dto.UserResponseDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserResponseDto> findAllUser() {
        // DB 조회
        String sql = "SELECT * FROM user";

        return jdbcTemplate.query(sql, new RowMapper<UserResponseDto>() {
            @Override
            public UserResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                // SQL 의 결과로 받아온 User 데이터들을 UserResponseDto 타입으로 변환해줄 메서드
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String pw = rs.getString("pw");
                return new UserResponseDto(id, name, email, pw);
            }
        });
    }
}
