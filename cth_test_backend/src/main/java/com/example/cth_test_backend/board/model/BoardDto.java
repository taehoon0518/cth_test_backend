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
    @Getter
    @Builder
    public static class ListResponse {
        private Long idx;
        private String title;
        private String writer;
        private int commentCount;
        public static ListResponse from(Board board) {
            return ListResponse.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .commentCount(board.getCommentCount())
                    .build();
        }
    }
}
