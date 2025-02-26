package com.example.cth_test_backend.board.model;

import com.example.cth_test_backend.comment.model.Comment;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String title;
    private String content;
    private String writer;

    private int commentCount;

    public void addComment() {
        this.commentCount++;
    }

    @OneToMany(mappedBy = "board")
    private List<Comment> comments;

    public Board(Long idx) {
        this.idx = idx;
    }
}