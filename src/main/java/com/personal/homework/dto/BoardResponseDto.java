package com.personal.homework.dto;

import com.personal.homework.entity.Board;

import java.time.LocalDateTime;

public class BoardResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String name;
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;


    // 생성자
    public BoardResponseDto(Board board) {
    this.id = board.getId();
    this.title = board.getTitle();
    this.name = board.getName();
    this.contents = board.getContents();
    this.modifiedAt = board.getModifiedAt();
    this.createdAt = board.getCreatedAt();
    }

    // Getter
    public Long getId() {
        return id;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getName() {
        return name;
    }
}


