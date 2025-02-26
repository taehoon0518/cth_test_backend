package com.example.cth_test_backend.comment;

import com.example.cth_test_backend.comment.model.Comment;
import com.example.cth_test_backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{idx}/register")
    public ResponseEntity<String> register(@PathVariable Long idx,
                                           @RequestBody CommentDto.RegisterRequest req) {
        commentService.register(idx, req);
        return ResponseEntity.ok("댓글 등록 완료");
    }
}
