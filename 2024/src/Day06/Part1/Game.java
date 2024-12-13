package Day06.Part1;

import Day06.Direction;
import Day06.TupleArray;

import java.awt.*;
import java.util.ArrayList;

class Game {
    private final char[][] field;
    private final Point currentPosition;
    private Direction currentDirection;
    private final ArrayList<Point> visitedFields = new ArrayList<>();
    private final TupleArray visitedObstacles = new TupleArray();

    public Game(char[][] field, Point currentPosition, Direction currentDirection) {
        this.field = field;
        this.currentPosition = currentPosition;
        this.currentDirection = currentDirection;
    }

    public void printVisitedObstacles() {
        System.out.println(visitedObstacles);
    }

    /**
     * @return {@code true} if the field moved to is a valid field, {@code false} otherwise
     */
    public boolean move() {
        addVisitedField(currentPosition);
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

        return visitedObstacles.contains(pointInFront, currentDirection);
    }

    public char getFieldAt(int x, int y) {
        return field[y][x];
    }

    public boolean isValidPosition(Point position) {
        return position.getX() >= 0 && position.getX() <= field[0].length -1 && position.getY() >= 0 && position.getY() <= field.length - 1;
    }

    private void addVisitedObstacle(Point point, Direction direction) {
        visitedObstacles.addEntry(point, direction);
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

    private void addVisitedField(Point point) {
        if(!wasPointAlreadyVisited(point)) {
            visitedFields.add(new Point(point.x, point.y));
        }
    }

    public char[][] getField() {
        return field;
    }

    public void setFieldAt(int x, int y, char c) {
        field[y][x] = c;
    }

    private boolean wasPointAlreadyVisited(Point point) {
        for(Point currentPoint : visitedFields) {
            if(currentPoint.getX() == point.getX() && currentPoint.getY() == point.getY()) {
                return true;
            }
        }

        return false;
    }

    public void rotateRight() {
        if(getFieldInFront(currentPosition) == '#') {
            switch(currentDirection) {
                case UP -> addVisitedObstacle(new Point(currentPosition.x, currentPosition.y - 1), currentDirection);
                case RIGHT -> addVisitedObstacle(new Point(currentPosition.x + 1, currentPosition.y), currentDirection);
                case DOWN -> addVisitedObstacle(new Point(currentPosition.x, currentPosition.y + 1), currentDirection);
                case LEFT -> addVisitedObstacle(new Point(currentPosition.x - 1, currentPosition.y), currentDirection);
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

    public int getResult() {
        return visitedFields.size();
    }
}
