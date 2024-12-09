package Day6;

import java.awt.*;
import java.util.ArrayList;

public class TupleArray {
    ArrayList<Point> points = new ArrayList<>();
    ArrayList<Direction> directions = new ArrayList<>();

    public void addEntry(Point point, Direction direction) {
        points.add(point);
        directions.add(direction);
    }

    public boolean contains(Point point, Direction direction) {
        for(int i = 0; i < points.size(); i++) {
            if(points.get(i).getX() == point.getX()
                    && points.get(i).getY() == point.getY()
                    && directions.get(i) == direction) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String str = "[\n";
        for(int i = 0; i < points.size(); i++) {
            str += "\t(" + (int) points.get(i).getX() + "|" + (int) points.get(i).getY() + "|" + directions.get(i) + ")";
            if(i != points.size() - 1) {
                str += ",";
            }
            str += "\n";
        }
        str += "]";
        return str;
    }
}