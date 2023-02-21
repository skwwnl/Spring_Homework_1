package com.personal.homework.dto;


import com.personal.homework.entity.Board;

public class BoardDeleteDto {
    private boolean success;
    public BoardDeleteDto(Board board){
        this.success = true;
    }

    public boolean getSuccess(){
        return success;
    }
}
