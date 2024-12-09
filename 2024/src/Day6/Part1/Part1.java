package Day6.Part1;

import Day6.Direction;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {
        Game game = parseInput(Path.of("./src/Day6/input.txt"));
        while(game.move()) {
            while(game.getFieldInFront(game.getCurrentPosition()) == '#') {
                game.rotateRight();
            }
        }

        System.out.println(game.getResult());
    }

    private static Game parseInput(Path path) throws IOException {
        List<String> inputLines = Files.readAllLines(path);

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


