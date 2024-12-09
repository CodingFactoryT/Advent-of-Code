package Day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 6395800119709 too low
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
                swapIfPossible(blocks, file, i);
                file.clear();
                if(blocks.get(i) != -1) {
                    i++;
                }
            }
        }
        swapIfPossible(blocks, file, file.size());
    }

    private static void swapIfPossible(ArrayList<Integer> blocks, ArrayList<Integer> file, int i) {
        int index = getIndexOfNManyFreeSpaces(blocks, file.size(), i);
        if(index != -1) {
            int startingIndexOfFile = i + 1;
            for(int j = index, k = 0; j < index + file.size(); j++, k++) {
                blocks.set(j, file.getFirst());
                blocks.set(startingIndexOfFile + k, -1);
            }
        }
    }

    private static int getIndexOfNManyFreeSpaces(ArrayList<Integer> blocks, int n, int max) {
        int amountOfFreeSpaces = 0;
        int index = 0;
        for(int i = 0; i < max; i++) {
            if(blocks.get(i) == -1) {
                amountOfFreeSpaces++;
                if(amountOfFreeSpaces >= n) {
                    return index;
                }
            } else {
                amountOfFreeSpaces = 0;
                index = i + 1;
            }
        }

        return -1;

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
