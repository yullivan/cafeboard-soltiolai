package cafeboard;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void createBoard(BoardRequest request){
        Board newBoard = new Board();
        newBoard.setName(request.name());
        boardRepository.save(newBoard);
    }

    public List<BoardResponse> getAllBoards(){
        return boardRepository.findAll()
                .stream()
                .map(board -> new BoardResponse(board.getId(),board.getName()))
                .toList();
    }

    public void updateBoard(Long id, BoardRequest request){
        Board existingBoard = boardRepository.findById(id)
                .orElseThrow();
        existingBoard.setName(request.name());
        boardRepository.save(existingBoard);
    }

    public void deleteBoard(Long id){
        boardRepository.deleteById(id);
    }
}
