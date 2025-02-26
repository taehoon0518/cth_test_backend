package com.example.cth_test_backend.board;

import com.example.cth_test_backend.board.model.Board;
import com.example.cth_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    public void register(BoardDto.RegisterRequest req) {
        boardRepository.save(req.toEntity(req));
    }

    public List<BoardDto.ListResponse> list() {
        List<Board> result = boardRepository.findAll();
        List<BoardDto.ListResponse> req = new ArrayList<>();
        for (Board board : result) {
            req.add(BoardDto.ListResponse.from(board));
        }
        return req;
    }
}
