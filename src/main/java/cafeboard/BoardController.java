package cafeboard;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/boards")
    public void createBoard(@RequestBody BoardRequest request){
        boardService.createBoard(request);
    }

    @GetMapping("/boards")
    public List<BoardResponse> getAllBoards(){
        return boardService.getAllBoards();
    }

    @PutMapping("/boards/{boardId}")
    public void updateBoard(@PathVariable Long id,
                            @RequestBody BoardRequest request){
        boardService.updateBoard(id, request);
    }

    @DeleteMapping("/boards/{boardId}")
    public void deleteBoard(@PathVariable Long id){
        boardService.deleteBoard(id);
    }
}
