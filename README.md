# Spring Test1 repository
Spring 프레임워크를 공부하고 주간 테스트를 기록하는 공간입니다.

## 🖥️ 스터디 저장소 소개
* 문제를 통한 요구사항 실습
* 코드 수정 및 기능 구현을 통해 부족한 부분을 체크하는 테스트

## 🕰️ 개발 기간
* 23.08.31

## 🧑‍🤝‍🧑 맴버구성
- 김인용

## ⚙️ 개발 환경
- **MainLanguage** : `Java - JDK 17`
- **IDE** : `IntelliJ IDEA Ultimate`
- **Framework** : `Spring Framework`
- **Database** : `MySQL(Local)`
- **SERVER** : `Spring inner server(not published)`
- **TEST** : `POSTMAN`
- **OS** : `MacOS`

## 👋🏻 Contact
- **Email** : citefred@yzpocket.com
- **Blog** : https://www.citefred.com

## 📕 시험문제

<details>
<summary> #시험 문제 </summary>
    
# [Spring] 회원 조회 API 만들기 (문제)

<aside>
💡 **Goal : 회원목록 조회 API를 만들어봅시다.**

</aside>

- 지금까지 배운 내용을 바탕으로 간단한 회원 목록 조회 API를 만들어봅시다.

<aside>
📌 **features : 구현해야 할 기능이에요.**

</aside>

- 구현해야하는 API 목록
    
    [API 설계](https://www.notion.so/ff967390b3bc4499a58d17d417e3cdb2?pvs=21)
    
    - 회원의 전체 목록을 조회하는 API (5점)
    - 한 회원의 userId를 주었을때 회원 정보를 조회하는 API (5점)
- 회원 목록 DB
    - userId : 회원 번호 (DB 인덱스)
    - name (String) : 회원 이름
    - email (String) : 회원 아이디
    - pw (String) : 회원 비밀번호
        
        ![스크린샷 2022-09-26 오후 7.19.48.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cb3eee14-ee34-4cb4-b5a5-642df7dbe0fc/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-09-26_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_7.19.48.png)
        
    
- User 테이블을 그대로 반환하지 않고 생성자를 사용하여 DTO로 변환한 후 반환하세요.
- Exception은 `NullPointerException` 를 사용하세요.

<aside>
💡 채점 기준

</aside>

1. 회원 전체 조회, 회원 조회
    1. 조회에 사용되는 HTTP Method는 모두 GET이다. 응답 코드는 모두 200이다.
    2. 반환되는 본문의 형식은 모두 JSON이다.
        1. 회원 전체 조회는 JSON Object 배열의 반환이다. 즉, [user, user, user]와 같다. { users: [user, user, …]}등은 허용되지 않는다.
            1. 배열의 모든 요소는 회원 정보이다. 각 회원정보는 중괄호 Key:Value 매핑인 JSON Object이다.
        2. 개인 조회는 JSON Object의 반환이다.
            1. 문제 명시된 필수 요소들을 포함한다.
            2. 필수 요소: User {userId, name, email, pw}
    3. 회원의 조회는 회원 전체 조회 시 반환된 목록 중 1명을 골라 userId를 획득해 개인 조회한 후, 정보가 일치하는지 검사한다.
        1. 정확히 ‘userId’필드여야 한다. _id, id등으로 지정되어있다면 개인 조회에 사용할 userId가 없으므로 개인조회는 0점으로 처리된다.
    4. g에 따라 회원 전체 조회가 실패할 경우 0점으로 처리된다.
    5. 조회는 총 3번 재시도 된다. 한번이라도 성공할 경우 성공으로 채점된다.
2. 각 회원의 정보에 명시된 정보의 목록(userId, email, phone 등)
    1. 이 요소들은 각각 평가되며, 개인 회원의 채점에만 적용된다. 전체 조회시에는 각 회원 정보의 요소는 평가되지 않는다. 총 요소의 갯수만 평가된다.
    2. 200코드로 응답했을 경우 기본 점수 1점, userId / name / email / pw를 반환할 경우 각각 1점

<aside>
✅ 스켈레톤 코드

</aside>

- UserController.java

```java
package com.example.sparta.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 한 회원의 userId가 주었을때 회원 정보를 조회하는 API
     * @param id
     */
    @GetMapping("/user/{id}")
    public UserResponseDto getUserInfo((구현)) {
								(구현)
    }

    /**
     * 회원의 전체 목록을 조회하는 API
     */
    @GetMapping("/user")
    public List<UserResponseDto> getUserList() {
								(구현)
    }
    
}
```

- UserService.java

```java
package com.example.sparta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto findUser((구현)) {
										(구현)
    }

    public List<UserResponseDto> findAllUser() {
											(구현)
    }
}
```

- UserResponseDto.java

```java
package com.example.sparta.entity

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private String pw;

    public UserResponseDto((구현)) {
				        (구현)
    }
}
```
</details>
