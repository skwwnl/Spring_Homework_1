package com.personal.homework.service;


import com.personal.homework.dto.BoardDeleteDto;
import com.personal.homework.entity.Board;
import com.personal.homework.dto.BoardRequestDto;
import com.personal.homework.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;


    @Transactional (readOnly = true)
    public List<Board> allShow(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    // DB에 연결을 해서 저장을 하려면 @Entity가 걸려있는 Board 클래스를 인스턴스로 만들어서
    // 그 값을 사용해서 저장을 해야한다.
    public Board createBoard(BoardRequestDto requestDto){
        // DB에서 나오는 값은 아니고 생성자에서 나옴.
        Board board = new Board(requestDto);
        // save 함수 안에 board 인스턴스를 넣어주면 자동으로 쿼리가 생성되며 DB에 연결되며 저장됨.
        return boardRepository.save(board);
        // DB에 저장되지 않은 참조변수 board
//        return board;
    }

    @Transactional
    public Board selectShow(Long id) {
        return boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 번호의 게시글이 존재하지 않습니다.")
        );
    }

    @Transactional
    public Board update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        if (!board.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("패스워드가 맞지 않습니다.");
        }
        board.update(requestDto);
        return board;
    }


    @Transactional
    public String delete(Long id, BoardDeleteDto deleteDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("개시글이 존재하지 않습니다.")
        );
        if (!board.getPassword().equals(deleteDto.getPassword())){
            throw new IllegalArgumentException("패스워드가 맞지 않습니다.");
        }
        boardRepository.deleteById(id);
        return deleteDto.getSuccess();
    }
}
