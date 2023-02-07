package com.personal.homework.entity;


import com.personal.homework.dto.BoardRequestDto;
import com.personal.homework.dto.BoardResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Board extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contents;


    // 생성자
    public Board(BoardRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }

    //Setter
    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
    }
}