package Day06.Part2_Enhanced_Speed;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import Day06.Direction;

public class Part2 {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines(Path.of("./src/Day6/input.txt"));

        Game game = parseInput(inputLines);
        int startingPositionX = (int) game.getCurrentPosition().getX();
        int startingPositionY = (int) game.getCurrentPosition().getY();

        int height = game.getField().length;
        int width = game.getField()[0].length;

        int counter = 0;
        for(int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if((col == startingPositionX && row == startingPositionY) || game.getFieldAt(col, row) == '#') {
                    continue;
                }
                game = parseInput(inputLines);
                game.setFieldAt(col, row, '#');
                while(game.move()) {
                    if(game.isInALoop()) {
                        counter++;
                        break;
                    }

                    while(game.getFieldInFront(game.getCurrentPosition()) == '#') {
                        game.rotateRight();
                    }
                }
            }
        }

        System.out.println("[" + counter + "]");
    }

    private static Game parseInput(List<String> inputLines) {
        char[][] field = new char[inputLines.size()][inputLines.get(0).length()];
        Direction currentDirection = Direction.UP;
        Point currentPosition = new Point(-1, -1);

        for(int row = 0; row < inputLines.size(); row++) {
            for(int col = 0; col < inputLines.get(0).length(); col++) {
                field[row][col] = inputLines.get(row).charAt(col);
                switch(field[row][col]) {
                    case '^' -> {
                        currentDirection = Direction.UP;
                        currentPosition = new Point(col, row);
                    }
                    case '>' -> {
                        currentDirection = Direction.RIGHT;
                        currentPosition = new Point(col, row);
                    }
                    case 'v' -> {
                        currentDirection = Direction.DOWN;
                        currentPosition = new Point(col, row);
                    }
                    case '<' -> {
                        currentDirection = Direction.LEFT;
                        currentPosition = new Point(col, row);
                    }
                }
            }
        }

        return new Game(field, currentPosition, currentDirection);
    }

}


