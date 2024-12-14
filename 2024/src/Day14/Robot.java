package Day14;

import java.awt.*;

public class Robot {
    private final Point position;
    private final Point velocity;

    public Robot(Point position, Point velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public void move(final int roomWidth, final int roomHeight) {
        double newX = (this.position.getX() + this.velocity.getX()) % roomWidth;
        double newY = (this.position.getY() + this.velocity.getY()) % roomHeight;

        if(newX < 0) {
            newX += roomWidth;
        }
        if(newY < 0) {
            newY += roomHeight;
        }

        this.position.setLocation(newX, newY);
    }

    public Point getPosition() {
        return position;
    }

    public void printPosition() {
        System.out.println("(" + (int) this.position.getX() + "|" + (int) this.position.getY() + ")");
    }
}
