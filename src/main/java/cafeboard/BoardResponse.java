package cafeboard;

public record BoardResponse(
        Long id,
        String name
) {
    @Override
    public Long id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }
}
