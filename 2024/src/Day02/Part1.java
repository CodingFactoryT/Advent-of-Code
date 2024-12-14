package Day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines(Path.of("./2024/src/Day2/input.txt"));
        int[][] reports = inputLines.stream()
                .map(report -> Arrays.stream(report.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);

        int amountOfSafeReports = 0;
        for(int[] report : reports) {
            if(isSafeReport(report)) {
                amountOfSafeReports++;
            }
        }

        System.out.println(amountOfSafeReports);

    }

    private static boolean isSafeReport(int[] report) {
        boolean containsIncreasing = false;
        boolean containsDecreasing = false;
        for(int i = 1; i < report.length; i++) {
            if(Math.abs(report[i-1] - report[i]) < 1 || Math.abs(report[i-1] - report[i]) > 3) {
                return false;
            }

            if(report[i-1] < report[i]) {
                containsIncreasing = true;
            }

            if(report[i-1] > report[i]) {
                containsDecreasing = true;
            }
        }

        return containsIncreasing ^ containsDecreasing;
    }
}
