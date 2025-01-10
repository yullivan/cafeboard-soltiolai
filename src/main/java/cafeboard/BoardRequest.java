package cafeboard;

public record BoardRequest(
        String name
) {
    @Override
    public String name() {
        return name;
    }
}
