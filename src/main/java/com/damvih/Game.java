package com.damvih;

import java.util.LinkedList;

public class Game {
    private Mark markToMove;
    private GameState gameState;

    public GameState getGameState() {
        return gameState;
    }

    private final Board board;
    private final InputCoordinates inputCoordinates;

    public Game(Settings settings) {
        board = new Board(settings);
        inputCoordinates = new InputCoordinates(settings.size);
    }

    private boolean checkIfWinningSize(LinkedList<Mark> marks) {
        int count = 1;
        Mark previousMark = null;
        for (Mark mark : marks) {
            if (mark == previousMark && mark != Mark.EMPTY) {
                count += 1;
            } else {
                count = 1;
            }
            previousMark = mark;
            if (count == board.settings.winningSize) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfDraw() {
        for (int row = 0; row < board.settings.size; row++) {
            for (int column = 0; column < board.settings.size; column++) {
                if (board.getField()[row][column] == Mark.EMPTY) return false;
            }
        }
        return true;
    }

    private GameState checkState(int row, int column) {
        if (checkIfWinningSize(board.getRow(row)) ||
                checkIfWinningSize(board.getColumn(column)) ||
                checkIfWinningSize(board.getLeftDiagonals(row, column)) ||
                checkIfWinningSize(board.getRightDiagonal(row, column))
        ) {
            return (markToMove == Mark.X) ? GameState.X_WINS : GameState.O_WINS;
        } else if (checkIfDraw()) {
            return GameState.DRAW;
        }
        return GameState.CONTINUE;
    }

    public void gameLoop() {
        board.createBoard();
        gameState = GameState.CONTINUE;
        markToMove = Mark.X;
        int row, column;
        while (true) {
            int[] input = inputCoordinates.ConsoleInput();
            row = input[0];
            column = input[1];
            if (!board.setMark(row, column, markToMove)) {
                continue;
            }
            Render.ConsoleRender(board);
            gameState = checkState(row, column);
            markToMove = markToMove.opposite();
            if (gameState != GameState.CONTINUE) {
                break;
            }
        }
    }
}
