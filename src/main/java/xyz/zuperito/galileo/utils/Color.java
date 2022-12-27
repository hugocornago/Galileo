package xyz.zuperito.galileo.utils;

public enum Color {
    WHITE(java.awt.Color.WHITE),
    LIGHT_GRAY(java.awt.Color.LIGHT_GRAY),
    GRAY(java.awt.Color.GRAY),
    DARK_GRAY(java.awt.Color.DARK_GRAY),
    BLACK(java.awt.Color.BLACK),
    RED(java.awt.Color.RED),
    PINK(java.awt.Color.PINK),
    ORANGE(java.awt.Color.ORANGE),
    YELLOW(java.awt.Color.YELLOW),
    GREEN(java.awt.Color.GREEN),
    MAGENTA(java.awt.Color.MAGENTA),
    CYAN(java.awt.Color.CYAN),
    BLUE(java.awt.Color.BLUE);

    final java.awt.Color color;

    Color(java.awt.Color color) {
        this.color = color;
    }

    public java.awt.Color getColor() {
        return color;
    }
}