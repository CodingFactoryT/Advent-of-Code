package Day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part1And2 {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines(Path.of("./2024/src/Day8/input.txt"));
        char[][] map = parseInput(inputLines);

        AntennaMap antennaMapPart1 = new AntennaMap(map, Part.PART1);
        System.out.println("Part 1: " + antennaMapPart1.getCountOfDistinctAntinodePositions());

        AntennaMap antennaMapPart2 = new AntennaMap(map, Part.PART2);
        System.out.println("Part 2: " + antennaMapPart2.getCountOfDistinctAntinodePositions());
    }

    private static char[][] parseInput(List<String> inputLines) {
        char[][] map = new char[inputLines.size()][inputLines.getFirst().length()];

        for(int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                map[row][col] = inputLines.get(row).charAt(col);
            }
        }

        return map;
    }
}
