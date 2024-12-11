package Day10.Part1;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines(Path.of("./2024/src/Day10/input.txt"));
        byte[][] map = parseInput(inputLines);
        HeatMap heatMap = new HeatMap(map);
        System.out.println(heatMap.getSummedTrailHeadScore());
    }

    private static byte[][] parseInput(List<String> inputLines) {
        byte[][] arr = new byte[inputLines.size()][inputLines.getFirst().length()];

        for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[0].length; col++) {
                arr[row][col] = Byte.parseByte(String.valueOf(inputLines.get(row).charAt(col)));
            }
        }

        return arr;
    }

}
