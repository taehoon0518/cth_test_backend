package com.example.cth_test_backend.board.model;

import lombok.Builder;
import lombok.Getter;

public class BoardDto {
    @Getter
    @Builder
    public static class RegisterRequest {
        private String title;
        private String content;
        private String writer;
        public Board toEntity(BoardDto.RegisterRequest req) {
            return Board.builder()
                    .title(req.title)
                    .content(req.content)
                    .writer(req.writer)
                    .build();
        }
    }
}
