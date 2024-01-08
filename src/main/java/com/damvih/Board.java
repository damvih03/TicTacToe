package com.damvih;

import java.util.LinkedList;

public class Board {
    public final Settings settings;
    private Mark[][] field;
    public Mark[][] getField() {
        return field;
    }
    public Board(Settings settings) {
        this.settings = settings;
    }
    public void createBoard() {
        field = new Mark[settings.size][settings.size];
        for (int row = 0; row < settings.size; row++) {
            for (int column = 0; column < settings.size; column++) {
                field[row][column] = Mark.EMPTY;
            }
        }
    }
    public boolean setMark(int row, int column, Mark mark) {
        if (row >= 0 && column >= 0 && row < settings.size && column < settings.size) {
            if (field[row][column] == Mark.EMPTY) {
                field[row][column] = mark;
                return true;
            }
        }
        return false;
    }
    public LinkedList<Mark> getRow(int row) {
        LinkedList<Mark> marks = new LinkedList<>();
        for (int column = 0; column < settings.size; column++) {
            marks.add(field[row][column]);
        }
        return marks;
    }
    public LinkedList<Mark> getColumn(int column) {
        LinkedList<Mark> marks = new LinkedList<>();
        for (int row = 0; row < settings.size; row++) {
            marks.add(field[row][column]);
        }
        return marks;
    }
    public LinkedList<Mark> getLeftDiagonals(int row, int column) {
        LinkedList<Mark> marks = new LinkedList<>();
        if (Math.abs(column - row) <= settings.size - settings.winningSize) {
            int difference = column - row;
            if (difference > 0) {
                for (int i = difference; i < settings.size; i++) {
                    marks.add(field[i - difference][i]);
                }
            } else {
                for (int i = -difference; i < settings.size; i++) {
                    marks.add(field[i][i + difference]);
                }
            }
        }
        return marks;
    }
    public LinkedList<Mark> getRightDiagonal(int row, int column) {
        int sum = row + column;
        LinkedList<Mark> marks = new LinkedList<>();
        if (sum < 2 * settings.size - settings.winningSize) {
            if (sum > settings.size - 1) {
                for (int i = sum - settings.size + 1; i < settings.size; i++) {
                    marks.add(field[i][sum - i]);
                }
            } else {
                for (int i = 0; i < sum + 1; i++) {
                    marks.add(field[i][sum - i]);
                }
            }
        }
        return marks;
    }
}
