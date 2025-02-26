package com.example.cth_test_backend.board;

import com.example.cth_test_backend.board.model.Board;
import com.example.cth_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    public void register(BoardDto.RegisterRequest req) {
        boardRepository.save(req.toEntity(req));
    }
}
