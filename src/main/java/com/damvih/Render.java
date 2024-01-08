package com.damvih;

public class Render {
    public static void ConsoleRender(Board board) {
        for (int row = 0; row < board.settings.size; row++) {
            String line = "| ";
            for (int column = 0; column < board.settings.size; column++) {
                String element;
                if (board.getField()[row][column] == Mark.X) {
                    element = "X";
                }
                else if (board.getField()[row][column] == Mark.O) {
                    element = "O";
                }
                else {
                    element = "*";
                }
                line += element + " ";
            }
            line += "|";

            System.out.println(line);
        }
    }
}
