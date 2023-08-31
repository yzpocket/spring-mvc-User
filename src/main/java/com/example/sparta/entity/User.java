package com.example.sparta.entity;

import com.example.sparta.dto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long userId;
    private String name;
    private String email;
    private String pw;
    public User(UserRequestDto requestDto) {
        this.userId = requestDto.getUserId();
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
        this.pw = requestDto.getPw();
    }
}
