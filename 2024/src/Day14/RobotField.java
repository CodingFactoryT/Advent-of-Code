package Day14;

import java.util.ArrayList;
import java.util.HashMap;

public class RobotField {
    ArrayList<Robot> robots;
    HashMap<String, ArrayList<Robot>> quadrants = new HashMap<>();
    private final int ROOM_WIDTH;
    private final int ROOM_HEIGHT;

    public RobotField(ArrayList<Robot> robots, final int roomWidth, final int roomHeight) {
        this.robots = robots;
        this.ROOM_WIDTH = roomWidth;
        this.ROOM_HEIGHT = roomHeight;

        quadrants.put("TOP-LEFT", new ArrayList<>());
        quadrants.put("TOP-RIGHT", new ArrayList<>());
        quadrants.put("BOTTOM-LEFT", new ArrayList<>());
        quadrants.put("BOTTOM-RIGHT", new ArrayList<>());
    }

    public void moveAllRobots() {
        for(Robot robot : robots) {
            robot.move(ROOM_WIDTH, ROOM_HEIGHT);
        }
    }

    private void putRobotsIntoQuadrants() {
        int centerX = ROOM_WIDTH / 2;
        int centerY = ROOM_HEIGHT / 2;

        for(Robot robot : robots) {
            int robotX = (int) robot.getPosition().getX();
            int robotY = (int) robot.getPosition().getY();

            String quadrantIdentifier = "";
            if(robotX < centerX && robotY < centerY) {
                quadrantIdentifier = "TOP-LEFT";
            } else if(robotX > centerX && robotY < centerY) {
                quadrantIdentifier = "TOP-RIGHT";
            } else if(robotX < centerX && robotY > centerY) {
                quadrantIdentifier = "BOTTOM-LEFT";
            } else if(robotX > centerX && robotY > centerY) {
                quadrantIdentifier = "BOTTOM-RIGHT";
            }

            if(!quadrantIdentifier.isEmpty()) {
                ArrayList<Robot> newList = quadrants.get(quadrantIdentifier);
                newList.add(robot);
                quadrants.put(quadrantIdentifier, newList);
            }
        }
    }

    public long getSafetyFactor() {
        putRobotsIntoQuadrants();
        long safetyFactor = 1;
        for(String quadrantIdentifier : quadrants.keySet()) {
            safetyFactor *= quadrants.get(quadrantIdentifier).size();
        }

        return safetyFactor;
    }
}
