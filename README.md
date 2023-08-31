# Spring MVC Mini Project
[Spring] MVC 프로젝트(project User)

## 🖥️ 프로젝트 소개
해당 프로젝트는 회원의 정보를 조회하는 API 테스트 Spring MVC 프로젝트입니다.

Spring Framework를 활용한 회원 전체 조회, 특정 회원 정보 조회 할 수 있습니다.

## 🕰️ 개발 기간
* 23.08.31 - 23.08.31

### 🧑‍🤝‍🧑 맴버구성
- (팀장) 김인용 - READ 기능

### ⚙️ 개발 환경
- **MainLanguage** : `Java` - JDK 17
- **IDE** : IntelliJ IDEA Ultimate
- **Framework** : Spring Framework
- **Database** : MySQL(Local)
- **SERVER** : Spring inner server(not published) / Tested by POSTMAN

## 📌 주요 기능
#### 블로깅 기본 기능
* [1] 회원 전체 목록 조회(READ)
    - GET 방식 API를 통한 전체 회원 목록 불러오기
* [2] 선택한 회원 보기(READ)
    - GET 방식 API를 통한 선택한 회원의 정보 보기

## ⚠️ 주의
#### 추적 예외
* src/main/resources/application.properties 파일은 DB 접속 정보가 있어 추적이 제외되어 있습니다.
* 테스트를 진행 하시려면 위 경로와 파일(application.properties)을 생성해주세요.
- 다음과 코드를 입력해주세요 < ... > 부분을 작성해주셔야 합니다. "<", ">" 괄호도 제거되어야 합니다.
- ex) spring.datasource.username=root
```
spring.datasource.url=jdbc:mysql://localhost:3306/blog
spring.datasource.username=<USERNAME>
spring.datasource.password=<PASSWORD>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```