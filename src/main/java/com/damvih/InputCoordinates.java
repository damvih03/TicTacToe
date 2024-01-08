package com.damvih;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record InputCoordinates(int size) {
    public int[] ConsoleInput() {
        Scanner scanner = new Scanner(System.in);

        int row, column;
        do {
            System.out.printf("Введите 2 числа (ряд и колонку) от 1 до %d через пробел (1-%d):%n", size, size);
            String input = scanner.nextLine();
            if (isStringCorrect(input)) {
                String[] inputData = input.split(" ");
                row = Integer.parseInt(inputData[0]) - 1;
                column = Integer.parseInt(inputData[1]) - 1;
                if (isInRange(row, column)) {
                    return new int[]{row, column};
                }
            }
            System.out.println("Введите корректные координаты!");
        } while (true);
    }

    private boolean isInRange(int row, int column) {
        return row >= 0 && column >= 0 && row < size && column < size;
    }

    private boolean isStringCorrect(String input) {
        String stringSize = Integer.toString(size);
        int lengthSize = stringSize.length() - 1;
        String regex = String.format("^[1-9][0-9]{0,%d} [1-9][0-9]{0,%d}$", lengthSize, lengthSize);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
