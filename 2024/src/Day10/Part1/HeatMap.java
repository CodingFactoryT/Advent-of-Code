package Day10.Part1;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class HeatMap {
    private final byte[][] heatMap;
    public final HashMap<Point, ArrayList<Point>> trailHeadScores = new HashMap<>();

    public HeatMap(byte[][] heatMap) {
        this.heatMap = heatMap;
        fillTrailHeadScores();
        calculateHeadScores();
    }

    private void calculateHeadScores() {
        for(Point trailHead : trailHeadScores.keySet()) {
            setTrailHeadScore(trailHead, trailHead);
        }
    }

    private void setTrailHeadScore(Point trailHead, Point currentPosition) {
        byte currentHeight = getHeightAt(currentPosition);
        if(currentHeight == 9 && !trailHeadScores.get(trailHead).contains(currentPosition)) {
            ArrayList<Point> newList = trailHeadScores.get(trailHead);
            newList.add(currentPosition);
            trailHeadScores.put(trailHead, newList); //increase value at key by one
            return;
        }

        Point positionUp = new Point((int) currentPosition.getX(), (int) (currentPosition.getY() - 1));
        if(isValidPosition(positionUp) && getHeightAt(positionUp) == currentHeight + 1) {
            setTrailHeadScore(trailHead, positionUp);
        }

        Point positionRight = new Point((int) currentPosition.getX() + 1, (int) (currentPosition.getY()));
        if(isValidPosition(positionRight) && getHeightAt(positionRight) == currentHeight + 1) {
            setTrailHeadScore(trailHead, positionRight);
        }

        Point positionDown = new Point((int) currentPosition.getX(), (int) (currentPosition.getY() + 1));
        if(isValidPosition(positionDown) && getHeightAt(positionDown) == currentHeight + 1) {
            setTrailHeadScore(trailHead, positionDown);
        }

        Point positionLeft = new Point((int) currentPosition.getX() - 1, (int) (currentPosition.getY()));
        if(isValidPosition(positionLeft) && getHeightAt(positionLeft) == currentHeight + 1) {
            setTrailHeadScore(trailHead, positionLeft);
        }
    }

    private byte getHeightAt(Point p) {
        return heatMap[(int) p.getY()][(int) p.getX()];
    }

    private boolean isValidPosition(Point p) {
        return p.getX() >= 0 && p.getX() <= heatMap[0].length - 1 && p.getY() >= 0 && p.getY() <= heatMap.length - 1;
    }

    private void fillTrailHeadScores() {
        for(int row = 0; row < heatMap.length; row++) {
            for(int col = 0; col < heatMap[0].length; col++) {
                if(heatMap[row][col] == 0) {
                    trailHeadScores.put(new Point(col, row), new ArrayList<>());
                }
            }
        }
    }

    public int getSummedTrailHeadScore() {
        int sum = 0;
        for(ArrayList<Point> points: trailHeadScores.values()) {
            sum += points.size();
        }

        return sum;
    }
}
