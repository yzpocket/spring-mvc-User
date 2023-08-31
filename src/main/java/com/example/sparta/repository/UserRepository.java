package com.example.sparta.repository;

import com.example.sparta.dto.UserResponseDto;
import com.example.sparta.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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

    // id로 회원 찾기
    public UserResponseDto findUserById(Long id) {
        // DB 조회
        String sql = "SELECT * FROM user WHERE id = ?";

        UserResponseDto userResponseDto = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, rowNum) -> {
            UserResponseDto user = new UserResponseDto();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setPw(resultSet.getString("pw"));
            return user;
        });

        if (userResponseDto == null) { //예외 던지기 여기가 가장 낮은 계층이라서 여기서 예외처리했음.
            throw new NullPointerException("사용자가 없습니다.");
        }
        return userResponseDto;
    }
}
