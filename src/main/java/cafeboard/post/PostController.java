package cafeboard.post;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //생성
    @PostMapping("/posts")
    public void createPost(@RequestBody PostRequest request){
        postService.createPost(request);
    }

    //전체 게시글 조회
    @GetMapping("/posts")
    public List<PostResponse> getAllPosts(){
        return postService.getAllPosts();
    }

    //게시글 한 개 조회
    @GetMapping("/posts/{postId}")
    public PostDetailResponse getPostDetail(@PathVariable long id){
        return postService.getPostDetail(id);
    }

    //수정
    @PutMapping("/posts/{postId}")
    public void updatePost(@PathVariable long id,
                           @RequestBody PostRequest request){
        postService.updatePost(id, request);
    }

    //삭제
    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
