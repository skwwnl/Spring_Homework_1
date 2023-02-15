package com.personal.homework.dto;


public class BoardDeleteDto {
    private String success;
    private String password;
    public BoardDeleteDto(){
        this.success = "삭제하였습니다";
    }

    public String getPassword(){ return password;}
    public String getSuccess(){
        return success;
    }
}
