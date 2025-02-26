package com.example.cth_test_backend.comment.model;

import com.example.cth_test_backend.board.model.Board;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String content;
    private String writer;
    @ManyToOne
    @JoinColumn(name = "board_idx")
    private Board board;
}
