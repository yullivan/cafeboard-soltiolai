package cafeboard.post;

import cafeboard.comment.CommentResponse;

import java.util.List;

public record PostDetailResponse(
        Long id,
        String title,
        String content,
        String author,
        List<CommentResponse> comments
) {
}
