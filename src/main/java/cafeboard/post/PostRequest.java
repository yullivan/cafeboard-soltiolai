package cafeboard.post;

public record PostRequest(
        String title,
        String content,
        String author,
        Long boardId
) {
}
