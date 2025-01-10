package cafeboard.comment;

public record CommentRequest(
        Long id,
        String content,
        String author,
        Long postId
) {
}
