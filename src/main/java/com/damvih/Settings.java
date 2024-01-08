package com.damvih;

public enum Settings {
    CLASSIC(3, 3),
    GOMOKU(15, 5);
    public final int size, winningSize;
    Settings(int size, int winningSize) {
        this.size = size;
        this.winningSize = winningSize;
    }
}
