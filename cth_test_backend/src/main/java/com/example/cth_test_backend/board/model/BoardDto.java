package com.example.cth_test_backend.board.model;

import com.example.cth_test_backend.comment.model.Comment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

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
    @Getter
    @Builder
    public static class ReadResponse {
        private String title;
        private String writer;
        private String content;
        private List<CommentDto> comments;
        public static ReadResponse from(Board board, List<CommentDto> comments) {
            return ReadResponse.builder()
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .content(board.getContent())
                    .comments(comments)
                    .build();
        }
    }
    @Builder
    @Getter
    public static class CommentDto {
        private String content;
        private String writer;
        public static CommentDto from (Comment comment) {
            return CommentDto.builder()
                    .content(comment.getContent())
                    .writer(comment.getWriter())
                    .build();
        }
    }
}
