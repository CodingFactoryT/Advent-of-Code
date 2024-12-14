package Day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {
        Data data = parseInput(Path.of("./src/Day5/input.txt"));

        int sum = getSum(data);
        System.out.println(sum);
    }

    private static int getSum(Data data) {
        int sum = 0;
        for(Integer[] pages : data.updates) {
            sum += calculateMiddle(data.rules, pages);
        }
        return sum;
    }

    private static int calculateMiddle(ArrayList<Integer[]> rules, Integer[] pages) {
        boolean isValid = true;
        List<Integer> pagesList = Arrays.stream(pages).toList();
        for(Integer[] rule : rules) {
            if(pagesList.contains(rule[0]) && pagesList.contains(rule[1])) {
                if(pagesList.indexOf(rule[0]) > pagesList.indexOf(rule[1])) {
                    isValid = false;
                    break;
                }
            }
        }

        return isValid ? getMiddle(pages) : 0;
    }

    private static Data parseInput(Path inputFilePath) throws IOException {
        List<String> inputLines = Files.readAllLines(inputFilePath);
        int iterationIndex = 0;
        ArrayList<Integer[]> rules = new ArrayList<>();
        while(!inputLines.get(iterationIndex).equals("")) {
            String[] split = inputLines.get(iterationIndex).split("\\|");
            int int1 = Integer.parseInt(split[0]);
            int int2 = Integer.parseInt(split[1]);

            rules.add(new Integer[]{int1, int2});
            iterationIndex++;
        }

        iterationIndex++;

        ArrayList<Integer[]> updates = new ArrayList<>();
        while(iterationIndex < inputLines.size()) {
            Integer[] pages = Arrays.stream(inputLines.get(iterationIndex).split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            updates.add(pages);
            iterationIndex++;
        }

        return new Data(rules, updates);
    }

    private static int getMiddle(Integer[] arr) {
        int index = arr.length / 2;
        return arr[index];
    }
}