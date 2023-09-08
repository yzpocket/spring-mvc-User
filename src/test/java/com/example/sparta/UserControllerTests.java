package com.example.sparta;

import com.example.sparta.controller.UserController;
import com.example.sparta.dto.UserResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserControllerTests {

    @Autowired
    private UserController userController;

    @Test
    public void testGetUserList() {
        // 테스트할 로직 실행
        List<UserResponseDto> userList = userController.getUserList();

        // 검증
        assertEquals(3, userList.size()); // 예상되는 결과와 비교
    }

    @Test
    public void testGetUserInfo() {
        // 테스트할 로직 실행
        UserResponseDto user = userController.getUserInfo(1L);

        // 검증
        assertEquals("John", user.getName()); // 예상되는 결과와 비교
    }
}
