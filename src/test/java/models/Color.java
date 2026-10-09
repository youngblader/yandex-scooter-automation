package models;

public enum Color {
    BLACK("black"),
    GREY("grey");

    private final String id;

    Color(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}