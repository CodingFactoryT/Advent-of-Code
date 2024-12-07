package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Part1 {
    public static void main(String[] args) throws IOException {
        char[][] inputLines = Arrays.stream(Files.readAllLines(Path.of("./2024/src/Day4/input.txt")).toArray(new String[0])).map(String::toCharArray).toArray(char[][]::new);

        int occurences = 0;

        for(int y = 0; y < inputLines.length; y++) {
            for(int x = 0; x < inputLines[0].length; x++) {
                if(isHorizontalOccurrence(x, y, inputLines)) occurences++;
                if(isVerticalOccurrence(x, y, inputLines)) occurences++;
                if(isDiagonalOccurrenceTopLeftToBottomRight(x, y, inputLines)) occurences++;
                if(isDiagonalOccurrenceTopRightToBottomLeft(x, y, inputLines)) occurences++;
            }
        }

        System.out.println(occurences);
    }

    private static boolean isHorizontalOccurrence(int x, int y, char[][] arr) {
        int[] xCoordinates = new int[]{x, x+1, x+2, x+3};
        int[] yCoordinates = new int[]{y, y, y, y};
        if(!areValidCoordinates(xCoordinates, yCoordinates, arr[0].length - 1, arr.length - 1)) {
            return false;
        }

        String str = getString(xCoordinates, yCoordinates, arr);
        return isValidXMAS(str);
    }

    private static boolean isVerticalOccurrence(int x, int y, char[][] arr) {
        int[] xCoordinates = new int[]{x, x, x, x};
        int[] yCoordinates = new int[]{y, y+1, y+2, y+3};
        if(!areValidCoordinates(xCoordinates, yCoordinates, arr[0].length - 1, arr.length - 1)) {
            return false;
        }

        String str = getString(xCoordinates, yCoordinates, arr);
        return isValidXMAS(str);
    }

    private static boolean isDiagonalOccurrenceTopLeftToBottomRight(int x, int y, char[][] arr) {
        int[] xCoordinates = new int[]{x, x+1, x+2, x+3};
        int[] yCoordinates = new int[]{y, y+1, y+2, y+3};
        if(!areValidCoordinates(xCoordinates, yCoordinates, arr[0].length - 1, arr.length - 1)) {
            return false;
        }

        String str = getString(xCoordinates, yCoordinates, arr);
        return isValidXMAS(str);
    }

    private static boolean isDiagonalOccurrenceTopRightToBottomLeft(int x, int y, char[][] arr) {
        int[] xCoordinates = new int[]{x, x-1, x-2, x-3};
        int[] yCoordinates = new int[]{y, y+1, y+2, y+3};
        if(!areValidCoordinates(xCoordinates, yCoordinates, arr[0].length - 1, arr.length - 1)) {
            return false;
        }

        String str = getString(xCoordinates, yCoordinates, arr);
        return isValidXMAS(str);
    }

    private static boolean isValidXMAS(String str) {
        return str.equals("XMAS") || str.equals("SAMX");
    }

    private static boolean areValidCoordinates(int[] x, int[] y, int maxX, int maxY) {
        if(x.length != y.length) {
            return false;
        }

        for(int i = 0; i < x.length; i++) {
            if(x[i] < 0 || x[i] > maxX || y[i]  < 0 || y[i]  > maxY) {
                return false;
            }
        }

        return true;
    }

    private static String getString(int[] x, int[] y, char[][] arr) {
        String str = "";
        for(int i = 0; i < x.length; i++) {
            str += arr[y[i]][x[i]];
        }

        return str;
    }

}
