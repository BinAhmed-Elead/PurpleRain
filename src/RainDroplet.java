import java.awt.*;

public class RainDroplet {
    private static int direction;

    private Color color;
    private Dimension size;
    private Point position;
    private int speed = 5;


    public RainDroplet(Color color, Dimension size, Point position) {
        this.color = color;
        this.size = size;
        this.position = position;
    }

    public static int getDirection() {
        return direction;
    }

    public static void setDirection(int direction) {
        RainDroplet.direction = direction;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
    public void setPosition(int x,int y) {
        this.position = new Point(x,y);
    }
    public void setPosition(double x,double y) {
        this.position = new Point((int)Math.round(x),(int)Math.round(y));
    }
}
