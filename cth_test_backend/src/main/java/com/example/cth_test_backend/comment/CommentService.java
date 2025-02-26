package com.example.cth_test_backend.comment;

import com.example.cth_test_backend.board.BoardRepository;
import com.example.cth_test_backend.board.model.Board;
import com.example.cth_test_backend.comment.model.Comment;
import com.example.cth_test_backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public void register(Long idx, CommentDto.RegisterRequest req) {
        Comment comment = commentRepository.save(req.toEntity(idx, req));
        if (comment != null) {
            Board board = boardRepository.findById(idx).get();
            board.addComment();
            boardRepository.save(board);
        }
    }
}
