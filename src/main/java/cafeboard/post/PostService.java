package cafeboard.post;

import cafeboard.board.BoardRepository;
import cafeboard.comment.CommentResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostService(PostRepository postRepository, BoardRepository boardRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
    }

    //생성
    public void createPost(PostRequest request){
        Post post = new Post();
        post.setTitle(request.title());
        post.setContent(request.content());
        post.setAuthor(request.author());
        post.setBoard(boardRepository.findById(request.boardId())
                .orElseThrow(()-> new NoSuchElementException("존재하지 않는 게시판")));
        postRepository.save(post);
    }

    //전체 게시글 조회
    public List<PostResponse> getAllPosts(){
        return postRepository.findAll()
                .stream()
                .map(post -> new PostResponse(post.getId(), post.getTitle(), post.getAuthor(), post.getComments().size()))
                .toList();
    }

    //게시글 한 개 조회
    public PostDetailResponse getPostDetail(long id){
        Post post = postRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("찾을 수 없는 게시글"));
        List<CommentResponse> commentResponses = post.getComments()
                .stream()
                .map(comment -> new CommentResponse(comment.getId(), comment.getContent(), comment.getAuthor(), comment.getPost().getId()))
                .toList();
        return new PostDetailResponse(post.getId(), post.getTitle(), post.getContent(), post.getAuthor(), commentResponses);
    }

    //수정
    public void updatePost(long id, PostRequest request){
        Post existingPost = postRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("찾을 수 없는 게시글"));
        existingPost.setTitle(request.title());
        existingPost.setContent(request.content());
        postRepository.save(existingPost);
    }

    //삭제
    public void deletePost(long id){
        postRepository.deleteById(id);
    }

}
