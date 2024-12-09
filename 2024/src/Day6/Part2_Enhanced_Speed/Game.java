package Day6.Part2_Enhanced_Speed;

import Day6.Direction;
import Day6.TupleArray;

import java.awt.*;
import java.util.ArrayList;

class Game {
    private final char[][] field;
    private final Point currentPosition;
    private Direction currentDirection;
    private final TupleArray visitedFields = new TupleArray();

    public Game(char[][] field, Point currentPosition, Direction currentDirection) {
        this.field = field;
        this.currentPosition = currentPosition;
        this.currentDirection = currentDirection;
    }

    /**
     * @return {@code true} if the field moved to is a valid field, {@code false} otherwise
     */
    public boolean move() {
        addVisitedField(currentPosition, currentDirection);
        switch(currentDirection) {
            case UP -> currentPosition.setLocation(currentPosition.x, currentPosition.y - 1);
            case RIGHT -> currentPosition.setLocation(currentPosition.x + 1, currentPosition.y);
            case DOWN -> currentPosition.setLocation(currentPosition.x, currentPosition.y + 1);
            case LEFT -> currentPosition.setLocation(currentPosition.x - 1, currentPosition.y);
        };

        return isValidPosition(currentPosition);
    }

    public boolean isInALoop() {
        Point pointInFront = switch(currentDirection) {
            case UP -> new Point(currentPosition.x, currentPosition.y - 1);
            case RIGHT -> new Point(currentPosition.x + 1, currentPosition.y);
            case DOWN -> new Point(currentPosition.x, currentPosition.y + 1);
            case LEFT -> new Point(currentPosition.x - 1, currentPosition.y);
        };

        return visitedFields.contains(pointInFront, currentDirection);
    }

    public char getFieldAt(int x, int y) {
        return field[y][x];
    }

    public boolean isValidPosition(Point position) {
        return position.getX() >= 0 && position.getX() <= field[0].length -1 && position.getY() >= 0 && position.getY() <= field.length - 1;
    }

    private void addVisitedField(Point point, Direction direction) {
        if(!wasPointAlreadyVisited(point, direction)) {
            visitedFields.addEntry(point, direction);
        }
    }

    public char getFieldInFront(Point point) {
        if(!isValidPosition(point)) {
            return '.';
        }

        return switch (currentDirection) {
          case UP -> {
              Point newPoint = new Point((int) point.getX(), (int) point.getY() - 1);
              yield isValidPosition(newPoint) ? field[newPoint.y][newPoint.x] : '.';
          }
          case RIGHT -> {
              Point newPoint = new Point((int) point.getX() + 1, (int) point.getY());
              yield isValidPosition(newPoint) ? field[newPoint.y][newPoint.x] : '.';
          }
          case DOWN-> {
              Point newPoint = new Point((int) point.getX(), (int) point.getY() + 1);
              yield isValidPosition(newPoint) ? field[newPoint.y][newPoint.x] : '.';
          }
          case LEFT-> {
              Point newPoint = new Point((int) point.getX() - 1, (int) point.getY());
              yield isValidPosition(newPoint) ? field[newPoint.y][newPoint.x] : '.';
          }
        };
    }

    public char[][] getField() {
        return field;
    }

    public void setFieldAt(int x, int y, char c) {
        field[y][x] = c;
    }

    private boolean wasPointAlreadyVisited(Point point, Direction direction) {
        return visitedFields.contains(point, direction);
    }

    public void rotateRight() {
        if(getFieldInFront(currentPosition) == '#') {
            switch(currentDirection) {
                case UP -> addVisitedField(new Point(currentPosition.x, currentPosition.y - 1), currentDirection);
                case RIGHT -> addVisitedField(new Point(currentPosition.x + 1, currentPosition.y), currentDirection);
                case DOWN -> addVisitedField(new Point(currentPosition.x, currentPosition.y + 1), currentDirection);
                case LEFT -> addVisitedField(new Point(currentPosition.x - 1, currentPosition.y), currentDirection);
            };
        }

        this.currentDirection = switch(currentDirection) {
            case UP -> Direction.RIGHT;
            case RIGHT -> Direction.DOWN;
            case DOWN -> Direction.LEFT;
            case LEFT -> Direction.UP;
        };
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }
}
