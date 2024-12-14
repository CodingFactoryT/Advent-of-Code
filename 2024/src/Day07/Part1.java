package Day07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines(Path.of("./2024/src/Day7/input.txt"));

        long sum = 0;
        for(String line : inputLines) {
            String[] split = line.split(": ");
            String[] numbers_str = split[1].split(" ");

            long result = Long.parseLong(split[0]);
            long[] numbers = Arrays.stream(numbers_str).mapToLong(Long::parseLong).toArray();

            boolean isCalculable = checkCalculation(result, numbers, 1, Operator.ADD) | checkCalculation(result, numbers, 1, Operator.MULTIPLY);

            if(isCalculable) {
                sum += result;
            }
        }

        System.out.println(sum);
    }

    private static boolean checkCalculation(long result, long[] arr, int currentIndex, Operator operator) {
        if(arr[0] == result && currentIndex >= arr.length) {
            return true;
        }

        if(currentIndex >= arr.length) {
            return false;
        }

        long[] newArray = Arrays.copyOf(arr, arr.length);
        if(operator == Operator.ADD) {
            newArray[0] += newArray[currentIndex];
        } else {
            newArray[0] *= newArray[currentIndex];
        }

        currentIndex++;
        return checkCalculation(result, newArray, currentIndex, Operator.ADD) | checkCalculation(result, newArray, currentIndex, Operator.MULTIPLY);
    }
}
