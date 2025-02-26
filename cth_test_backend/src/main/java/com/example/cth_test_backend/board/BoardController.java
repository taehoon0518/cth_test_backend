package com.example.cth_test_backend.board;

import com.example.cth_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody BoardDto.RegisterRequest req){
        boardService.register(req);
        return ResponseEntity.ok("게시물 등록 완료");
    }
    @GetMapping("list")
    public String list(){
        return "list";
    }
}
