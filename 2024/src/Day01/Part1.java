package Day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines(Path.of("./2024/src/Day1/input.txt"));
        ArrayList<Integer> firstColumnNumbers = new ArrayList<>();
        ArrayList<Integer> secondColumnNumbers = new ArrayList<>();

        for(String line : inputLines) {
            String[] splittedLine = line.split("   ");
            firstColumnNumbers.add(Integer.parseInt(splittedLine[0]));
            secondColumnNumbers.add(Integer.parseInt(splittedLine[1]));
        }

        Collections.sort(firstColumnNumbers);
        Collections.sort(secondColumnNumbers);

        int sum = 0;

        for(int i = 0; i < firstColumnNumbers.size(); i++) {
            sum += Math.abs(firstColumnNumbers.get(i) - secondColumnNumbers.get(i));
        }

        System.out.println(sum);

    }
}
