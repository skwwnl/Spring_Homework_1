# Spring_Homework

Spring 1주차 개인 과제
=====================

## 서비스 완성 요구 사항

1. Use Case 그리기
2. 전체 게시글 목록 조회 API
3. 게시글 작성 API
4. 선택한 게시글 조회 API
5. 선택한 게시글 정정 API
6. 선택한 게시글 삭제 API

## UseCase

---

![1112.drawio (1).png](./homework/1112.drawio_(1).png)

## API 명세서

---

| ------------ | ---------------------- | ------------------------------- | ------------------------------------------------- |
|---------------|-------------------------|----------------------------------|----------------------------------------------------|
|              |                        |                                 | "createdAt": "2022-07-25T12:43:01.226062”,        |
|              |                        |                                 | "modifiedAt": "2022-07-25T12:43:01.226062”,       |
|              |                        |                                 | "id": 1,                                          |
|              |                        |                                 | "title": "title",                                 |
|              |                        |                                 | "name" : "name",                                  |
|              |                        |                                 | "password" : "password",                          |
|              |                        |                                 | "contents" : "contents"                           |
|              |                        |                                 | },                                                |
| POST         | /api/boards            | {                               | {                                                 |
|              |                        | "title" : title",               | "createdAt": "2022-07-25T12:43:01.226062”,        |
|              |                        | "name" : "name",                | "modifiedAt": "2022-07-25T12:43:01.226062”,       |
|              |                        |                                 | "id": 1,                                          |
|              |                        | "password" : "password",        | "title": "title",                                 |
|              |                        | "contents" : "contents"         | "name" : "name",                                  |
|              |                        | }                               | "password" : "password",                          |
|              |                        |                                 | "contents" : "contents"                           |
|              |                        |                                 | }                                                 |
|              |                        |                                 | "id": 1,                                          |
|              |                        |                                 | "title": "title",                                 |
|              |                        |                                 | "name" : "name",                                  |
|              |                        |                                 | "password" : "password",                          |
|              |                        |                                 | "contents" : "contents"                           |
|              |                        |                                 | }                                                 |
| GET          | /api/boards/{id}       | -                               | {                                                 |
|              |                        |                                 | "createdAt": "2022-07-25T12:43:01.226062”,        |
|              |                        |                                 | "modifiedAt": "2022-07-25T12:43:01.226062”,       |
|              |                        |                                 | "id": 2,                                          |
|              |                        |                                 | "title": "title2",                                |
|              |                        |                                 | "name" : "name2",                                 |
|              |                        |                                 | "password" : "password2",                         |
|              |                        |                                 | "contents" : "contents2"                          |
|              |                        |                                 | }                                                 |
| PUT          | /api/boards/{id}       | {                               | {                                                 |  |
|              |                        | "title" : "title2",             | "createdAt": "2022-07-25T12:43:01.226062”,        |
|              |                        | "name" : "name2",               | "modifiedAt": "2022-07-25T12:43:01.226062”,       |
|              |                        | "password" : "password2",       | "id": 1,                                          |
|              |                        | "contents" : "contents2"        | "title": "title2",                                |
|              |                        | }                               | "name" : "name2",                                 |
|              |                        |                                 | "password" : "password2",                         |
|              |                        |                                 | "contents" : "contents2"                          |
|              |                        |                                 | }                                                 |
| DELETE       | /api/boards/{id}       | {                               |                                                   |
|              |                        | "password" :"password"          | “삭제하였습니다”                                         |
|              |                        | }                               |                                                   |

## 질문

---

1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)
    1. body를 사용하였으며, URL에 값을 넣게 되면 보안에 취약하므로 payload에 담아 전달하였습니다.
2. 어떤 상황에 어떤 방식의 request를 써야하나요?
    1. 조회(전체도 포함) - GET
    2. 등록 - POST
    3. 변경 - PUT
    4. 삭제 - DELETE
3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
    1. URI에 boards에 속성에 해당하는 id 값을 전달하는 표현.
    2. 각 API에 맞는 Method들을 사용.
4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)
    1. Controller에서는 클라이언트의 요청을 받고 전달하는 역할만 구성.
    2. Service에서는 필요한 데이터를 받아와 재조립하여 필요한 값으로 전달.
    3. Repository는 JPA를 이용하여 DB와의 접근만 하게 분리.
5. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!
    1. 삭제 기능에서 Request에 대한 password만 JSON형태로 전달하는 것과 String으로 값을 받았지만 JSON으로 “success” : true 구현이 부족하였다.