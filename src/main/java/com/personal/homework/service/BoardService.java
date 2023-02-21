package com.personal.homework.service;


import com.personal.homework.dto.BoardDeleteDto;
import com.personal.homework.dto.BoardResponseDto;
import com.personal.homework.entity.Board;
import com.personal.homework.dto.BoardRequestDto;
import com.personal.homework.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;


    // 전체 게시물 조회
    @Transactional (readOnly = true)
    public List<BoardResponseDto> allBoard(){
        List<Board> board = boardRepository.findAll(); // JPA 기본 메소드 findAll 호출
        List<BoardResponseDto> boardResponseDtos = new ArrayList<>(); // List 생성
        for(Board boards : board){ // board의 값이 boards에 들어갈 때까지 작업.
            boardResponseDtos.add(new BoardResponseDto(boards));
        }
        return boardResponseDtos;
    }

    // 게시물 생성
    @Transactional
    // DB에 연결을 해서 저장을 하려면 @Entity가 걸려있는 Board 클래스를 인스턴스로 만들어서
    // 그 값을 사용해서 저장을 해야한다.
    public BoardResponseDto createBoard(BoardRequestDto requestDto){
        // DB에서 나오는 값은 아니고 생성자에서 나옴.
        Board board = new Board(requestDto);
        // save 함수 안에 board 인스턴스를 넣어주면 자동으로 쿼리가 생성되며 DB에 연결되며 저장됨.
        boardRepository.save(board);
        return new BoardResponseDto(board); // 저장이 진행된 board의 값을 Dto로 변환
    }

    // 게시물 선택
    @Transactional(readOnly = true)
    public BoardResponseDto selectBoard(Long id) {
        Board board =  boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 번호의 게시글이 존재하지 않습니다.")
        );
        return new BoardResponseDto(board); // 새로운 ResponseDto 인스턴스 생성
    }

    @Transactional
    public BoardResponseDto update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        if (!board.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("패스워드가 맞지 않습니다.");
        }
        board.update(requestDto);
        return new BoardResponseDto(board);
    }


    @Transactional
    public BoardDeleteDto delete(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("개시글이 존재하지 않습니다.")
        );
        if (!board.getPassword().equals(boardRequestDto.getPassword())){
            throw new IllegalArgumentException("패스워드가 맞지 않습니다.");
        }
        boardRepository.deleteById(id);
        return new BoardDeleteDto(board);
    }
}
