package com.example.cth_test_backend.board.model;

import com.example.cth_test_backend.comment.model.Comment;
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

    public Board(Long idx) {
        this.idx = idx;
    }

    @OneToMany(mappedBy = "board")
    private List<Comment> comments;
}