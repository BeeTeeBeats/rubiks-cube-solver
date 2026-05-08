package com.example;

public enum Color {
    WHITE('W', TextColor.WHITE),
    BLUE('B', TextColor.BLUE),
    RED('R', TextColor.RED),
    GREEN('G', TextColor.GREEN),
    ORANGE('O', TextColor.ORANGE),
    YELLOW('Y', TextColor.YELLOW);

    public enum TextColor {
        WHITE("\u001B[37m"),
        BLUE("\u001B[34m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        ORANGE("\u001B[38;5;208m"),
        YELLOW("\u001B[33m"),
        RESET("\u001B[0m");

        private final String ansiString;

        TextColor(String ansiString) {
            this.ansiString = ansiString;
        }

        public String getAnsiString() {
            return ansiString;
        }
    }

    private final char firstLetter;
    private final TextColor textColor;

    Color(char firstLetter, TextColor textColor) {
        this.firstLetter = firstLetter;
        this.textColor = textColor;
    }

    public char getFirstLetter() {
        return firstLetter;
    }

    public String getAnsiString() {
        return textColor.getAnsiString();
    }
}
