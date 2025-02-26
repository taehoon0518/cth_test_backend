package com.example.cth_test_backend.comment.model;

import com.example.cth_test_backend.board.model.Board;
import lombok.Builder;
import lombok.Getter;

public class CommentDto {
    @Getter
    @Builder
    public static class RegisterRequest{
        private String content;
        private String writer;

        public Comment toEntity(Long idx, CommentDto.RegisterRequest req){
            return Comment.builder()
                    .content(req.getContent())
                    .writer(req.getWriter())
                    .board(new Board(idx))
                    .build();

        }
    }
}
