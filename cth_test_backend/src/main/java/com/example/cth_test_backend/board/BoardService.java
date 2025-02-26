package com.example.cth_test_backend.board;

import com.example.cth_test_backend.board.model.Board;
import com.example.cth_test_backend.board.model.BoardDto;
import com.example.cth_test_backend.comment.CommentRepository;
import com.example.cth_test_backend.comment.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
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

    public BoardDto.ReadResponse read(Long idx) {
        Board board = boardRepository.findByIdx(idx);
        List<Comment> comment = commentRepository.findAllByBoardIdx(board.getIdx());
        List<BoardDto.CommentDto> comments = new ArrayList<>();
        for (Comment c : comment) {
            comments.add(BoardDto.CommentDto.from(c));
        }

        BoardDto.ReadResponse req = BoardDto.ReadResponse.from(board, comments);
        return req;
    }
}
