package cafeboard.comment;

import cafeboard.post.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    //생성
    public void createComment(long postId, CommentRequest request){
        Comment comment = new Comment();
        comment.setAuthor(request.author());
        comment.setContent(request.content());
        comment.setPost(postRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("찾을 수 없는 게시글")));
        commentRepository.save(comment);
    }

    //수정
    public void updateComment(long commentId, CommentRequest request){
        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("찾을 수 없는 게시글"));
        existingComment.setContent(request.content());
        commentRepository.save(existingComment);
    }

    //삭제
    public void deleteComment(long commentId){
        commentRepository.deleteById(commentId);
    }

}
