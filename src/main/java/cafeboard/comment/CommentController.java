package cafeboard.comment;

import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //생성
    @PostMapping("/posts/{postId}/comments")
    public void createComment(@PathVariable long postId,
                              @RequestBody CommentRequest request){
        commentService.createComment(postId, request);
    }

    //수정
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public void updateComment(@PathVariable long commentId,
                              @RequestBody CommentRequest request){
        commentService.updateComment(commentId, request);
    }

    //삭제
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public void deleteComment(@PathVariable long commentId){
        commentService.deleteComment(commentId);
    }
}
