package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Part2 {
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
        boolean isIterating = true;
        List<Integer> pagesList = new ArrayList<>(Arrays.stream(pages).toList());
        boolean toBeReturned = false;
        while(isIterating) {    //while not every rule is satisfied and checked at least once
            isIterating = false;    //stop the iteration process if no further elements get swapped
            for(Integer[] rule : rules) {   //check the rules and swap items until the rules are satisfied
                if(pagesList.contains(rule[0]) && pagesList.contains(rule[1])) {
                    if(pagesList.indexOf(rule[0]) > pagesList.indexOf(rule[1])) {   //if two elements are in the wrong order
                        Collections.swap(pagesList, pagesList.indexOf(rule[0]), pagesList.indexOf(rule[1]));    //swap these elements
                        isIterating = true;     //if there was a swap, check each rule again as now other rules could have been broken
                        toBeReturned = true;    //if the element needed a swap, it had at least two pages in the wrong order and thus should be returned
                    }
                }
            }
        }
        return toBeReturned ? getMiddle(pagesList) : 0;
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

    private static int getMiddle(List<Integer> arrList) {
        Integer[] arr = arrList.toArray(Integer[]::new);
        int index = arr.length / 2;
        return arr[index];
    }
}
