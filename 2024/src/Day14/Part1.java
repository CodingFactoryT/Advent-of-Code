package Day14;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Part1 {
    private static final int ROOM_WIDTH = 101;
    private static final int ROOM_HEIGHT = 103;
    private static final int ITERATION_COUNT = 100;
    public static void main(String[] args) throws IOException {
        String input  = Files.readString(Path.of("./2024/src/Day14/input.txt"));
        RobotField field = parseInput(input);
        for(int i = 0; i < ITERATION_COUNT; i++) {
            field.moveAllRobots();
        }
        System.out.println(field.getSafetyFactor());
    }

    private static RobotField parseInput(String input) {
        input = input.replaceAll("p=", "").replaceAll("v=", "").replaceAll(" ", ",");
        String[] robotsData = input.split("\n");
        ArrayList<Robot> robots = new ArrayList<>();

        for(String robotData : robotsData) {
            int[] data = Arrays.stream(robotData.split(","))
                    .mapToInt(str -> Integer.parseInt(str.trim()))
                    .toArray();
            Robot robot = new Robot(new Point(data[0], data[1]), new Point(data[2], data[3]));
            robots.add(robot);
        }

        return new RobotField(robots, ROOM_WIDTH, ROOM_HEIGHT);
    }
}
