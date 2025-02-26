package com.example.cth_test_backend.board;

import com.example.cth_test_backend.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.CharBuffer;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findByIdx(Long idx);
}
