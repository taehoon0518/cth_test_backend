package com.example.cth_test_backend.comment;

import com.example.cth_test_backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public void register(Long idx, CommentDto.RegisterRequest req) {
        commentRepository.save(req.toEntity(idx, req));
    }
}
