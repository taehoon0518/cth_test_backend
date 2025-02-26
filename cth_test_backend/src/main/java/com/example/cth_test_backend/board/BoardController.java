package com.example.cth_test_backend.board;

import com.example.cth_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<BoardDto.ListResponse>> list(){
        List<BoardDto.ListResponse> req = boardService.list();
        return ResponseEntity.ok(req);
    }
    @GetMapping("/{idx}")
    public ResponseEntity<BoardDto.ReadResponse> read(@PathVariable Long idx){
        BoardDto.ReadResponse req = boardService.read(idx);
        return ResponseEntity.ok(req);
    }
}
