package com.damvih;

public enum Mark {
    X,
    O,
    EMPTY;
    public Mark opposite() throws IllegalArgumentException{
        if (this == EMPTY) throw new IllegalArgumentException("It's impossible to oppose 'EMPTY' mark");
        return this == X ? O : X;
    }
}
