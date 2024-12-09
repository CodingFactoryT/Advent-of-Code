package Day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part1And2 {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines(Path.of("./2024/src/Day9/input.txt"));
        ArrayList<Integer> blocksPart1 = parseInput(inputLines.getFirst());
        compactBlocksPart1(blocksPart1);
        System.out.println(computeChecksum(blocksPart1));

        ArrayList<Integer> blocksPart2 = parseInput(inputLines.getFirst());
        compactBlocksPart2(blocksPart2);
        System.out.println(computeChecksum(blocksPart2));
    }

    private static ArrayList<Integer> parseInput(String inputLine) {
        ArrayList<Integer> blocks = new ArrayList<>();
        for(int i = 0; i < inputLine.length(); i += 2) {
            for(int j = 0; j < Character.getNumericValue(inputLine.charAt(i)); j++) {
                int index = i / 2;
                blocks.add(index);
            }
            if(i + 1 < inputLine.length()) {
                for(int j = 0; j < Character.getNumericValue(inputLine.charAt(i+1)); j++) {
                    blocks.add(-1);
                }
            }
        }

        return blocks;
    }

    private static void compactBlocksPart1(ArrayList<Integer> blocks) {
        for(int i = blocks.size() - 1; i >= 0; i--) {
            int index;
            if(blocks.get(i) != -1 && (index = blocks.indexOf(-1)) < i) {
                Collections.swap(blocks, i, index);
            }
        }
    }

    private static void compactBlocksPart2(ArrayList<Integer> blocks) {
        ArrayList<Integer> file = new ArrayList<>();
        for(int i = blocks.size() - 1; i >= 0; i--) {
                if(blocks.get(i) != -1 && (file.isEmpty() || file.getFirst() == blocks.get(i))) {
                    file.add(blocks.get(i));
                } else if(!file.isEmpty()){
                    int amountOfFreeSpace = 0;
                    int startingIndexOfFreeSpace = blocks.indexOf(-1);;
                    int j = startingIndexOfFreeSpace;
                    while(blocks.get(j) == -1) {
                        j++;
                        amountOfFreeSpace++;
                    }

                    file.clear();
                }
        }
        System.out.println(blocks);
    }

    private static long computeChecksum(ArrayList<Integer> compactedBlocks) {
        long sum = 0;
        for(int i = 0; i < compactedBlocks.size(); i++) {
            if(compactedBlocks.get(i) != -1) {
                sum += (long) i * compactedBlocks.get(i);
            }
        }
        return sum;
    }

}
