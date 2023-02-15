package com.personal.homework.controller;

import com.personal.homework.dto.BoardRequestDto;
import com.personal.homework.dto.BoardResponseDto;
import com.personal.homework.dto.BoardDeleteDto;
import com.personal.homework.entity.Board;
import com.personal.homework.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 모든 들어오는 나가는 Json으로 나간다.
@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class BoardController {

    // DI, Service 객체 불러오기
    private final BoardService boardService;

    // 모든 게시판 조회 API
    @GetMapping("/All_boards")
    public List<Board> allShow() {
        return boardService.allShow();
    }

    // Post 방식으로
    // 반환 값에 Entity가 있는 건 좋지 않다.
    // DTO로 변환 후에 Board를 대체하라
    @PostMapping("/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }

    // Get 방식으로 선택한 게시글 조회 API
    @GetMapping("/boards/{id}")
    public Board selectShow(@PathVariable Long id) {
        return boardService.selectShow(id);
    }

    // Put 방식으로 선택한 게시글 수정 API
    @PutMapping("/boards/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        Board board = boardService.update(id, requestDto);
        return new BoardResponseDto(board);
    }

    // Delete 방식으로 선택한 게시글 삭제 API
    @DeleteMapping("/boards/{id}")
    public String deleteBoard(@PathVariable Long id, @RequestBody BoardDeleteDto deleteDto) {
        String board = boardService.delete(id, deleteDto);
        return board;
    }

}
  // 이전 Code
//    @DeleteMapping("/boards/{id}")
//    public BoardResponseDto deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
//        Board board = boardService.delete(id, requestDto);
//        return new BoardResponseDto(board);
//    }
//}
