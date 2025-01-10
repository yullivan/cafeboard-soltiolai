package cafeboard.comment;

public record CommentResponse(
        Long id,
        String content,
        String author
) {
}
