package com.example.cth_test_backend.comment;

import com.example.cth_test_backend.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBoardIdx(Long idx);
}
