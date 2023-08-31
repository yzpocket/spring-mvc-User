package com.example.sparta.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {

    private Long userId;
    private String name;
    private String email;
    private String pw;

    public UserResponseDto(Long id, String name, String email, String pw) {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.pw = pw;
    }
}