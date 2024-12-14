package Day08;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AntennaMap {
    private final HashMap<Character, ArrayList<Point>> antennaPositions = new HashMap<>();
    private final ArrayList<Point> antinodes = new ArrayList<>();
    private final char[][] map;
    private final Part part;

    public AntennaMap(char[][] map, Part part) {
        this.map = map;
        this.part = part;
        addAntennaPositions();
        fillAntinodes();
    }

    public void fillAntinodes() {
        for(Character key : antennaPositions.keySet()) {
            ArrayList<Point> antennaPositionsOfSameFrequency = antennaPositions.get(key);
            ArrayList<Point> antinodesFromFrequency = this.getAntinodesFromPositions(antennaPositionsOfSameFrequency);
            for(Point antinodeFromFrequency : antinodesFromFrequency) {
                if(!antinodes.contains(antinodeFromFrequency)) {
                    antinodes.add(antinodeFromFrequency);
                }
            }
        }
    }

    private ArrayList<Point> getAntinodesFromPositions(ArrayList<Point> positions) {
        ArrayList<Point> antinodesFromPositions = new ArrayList<>();
        for(int i = 0; i < positions.size(); i++) {
            for(int j = i + 1; j < positions.size(); j++) {
                ArrayList<Point> antinodesForPair ;
                antinodesForPair = getAntinodesOfPair(positions.get(i), positions.get(j));
                antinodesFromPositions.addAll(antinodesForPair);
            }
        }

        return antinodesFromPositions;
    }

    private ArrayList<Point> getAntinodesOfPair(Point a, Point b) {
        int dx = (int) a.getX() - (int) b.getX();
        int dy = (int) a.getY() - (int) b.getY();
        ArrayList<Point> antinodesOfPair = new ArrayList<>();

        int maxIndexExclusive = this.part == Part.PART1 ? 2 : Math.max(map.length, map[0].length);
        for(int i = 1; i < maxIndexExclusive; i++) {
            Point delta = new Point(dx * i, dy * i);
            Point p1 = addPoints(a, delta);
            Point p2 = subtractPoints(a, delta);
            Point p3 = addPoints(b, delta);
            Point p4 = subtractPoints(b, delta);
            antinodesOfPair.addAll(new ArrayList<>(Arrays.asList(p1, p2, p3, p4)));
        }

        antinodesOfPair.removeIf(p -> !isValidPoint(p));
        if(this.part == Part.PART1) {
            antinodesOfPair.removeIf(p -> p.equals(a) || p.equals(b));
        }
        return antinodesOfPair;
    }

    private boolean isValidPoint(Point p) {
        return p.getX() >= 0 && p.getX() <= map[0].length - 1 && p.getY() >= 0 && p.getY() <= map.length - 1;
    }

    private Point addPoints(Point a, Point b) {
        return new Point((int) a.getX() + (int) b.getX(), (int) a.getY() + (int) b.getY());
    }

    private Point subtractPoints(Point a, Point b) {
        return new Point((int) a.getX() - (int) b.getX(), (int) a.getY() - (int) b.getY());
    }

    public int getCountOfDistinctAntinodePositions() {
        return antinodes.size();
    }

    private void addAntennaPositions() {
        for(int row = 0; row < map.length; row++) {
            for(int col = 0; col < map[0].length; col++) {
                char field = map[row][col];
                if(field == '.') {
                    continue;
                }

                if(antennaPositions.containsKey(field)) {
                    Point newPoint = new Point(col, row);
                    if(!antennaPositions.get(field).contains(newPoint)) {
                        antennaPositions.get(field).add(newPoint);
                    }
                } else {
                    ArrayList<Point> newPointList = new ArrayList<>();
                    newPointList.add(new Point(col, row));
                    antennaPositions.put(field, newPointList);
                }
            }
        }
    }
}
