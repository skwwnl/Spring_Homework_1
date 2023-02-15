package com.personal.homework.dto;


public class BoardRequestDto {
    private String title;
    private String name;
    private String password;
    private String contents;


    // 생성자 4개 속성
    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getContents() {
        return contents;
    }
}
