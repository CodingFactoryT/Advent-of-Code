package Day14;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Part2 {
    private static final int ROOM_WIDTH = 101;
    private static final int ROOM_HEIGHT = 103;
    public static void main(String[] args) throws IOException {
        String input  = Files.readString(Path.of("./2024/src/Day14/input.txt"));
        RobotField field = parseInput(input);

        int iteration = 0;
        while(true) {
            iteration++;
            field.moveAllRobots();

            BufferedImage image = field.getImageOfRobotField();
            if(!hasConsecutivePixels(image)) {
                continue;
            }
            System.out.println(iteration);
            break;
        }
    }

    private static boolean hasConsecutivePixels(BufferedImage image) {
        final int THRESHOLD = 10;

        int consecutives = 0;
        for(int row = 0; row < image.getHeight(); row++) {
            for(int col = 0; col < image.getWidth(); col++) {
                int pixel = image.getRGB(col, row);
                if(pixel == 0) {
                    consecutives = 0;
                } else {
                    consecutives++;
                }

                if(consecutives >= THRESHOLD) {
                    return true;
                }
            }
        }

        return false;
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
