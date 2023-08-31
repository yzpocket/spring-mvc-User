package com.example.sparta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private Long userId;
    private String name;
    private String email;
    private String pw;
}
