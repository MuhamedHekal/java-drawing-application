import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    protected int x1, x2, y1, y2;
    protected Color color;
    protected boolean filled;
    public static boolean limited = true;
    public static final Color[] COLORS = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.WHITE};
    static ArrayList<Shape> history = new ArrayList<>();

    public Shape() {}

    public Shape(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
        this.filled = filled;
    }

    public void setCoordinates(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public List<Integer> getX() {
        List<Integer> Xs = new ArrayList<>();
        Xs.add(x1);
        Xs.add(x2);
        return Xs;
    }

    public List<Integer> getY() {
        List<Integer> Ys = new ArrayList<>();
        Ys.add(y1);
        Ys.add(y2);
        return Ys;
    }

    public int xLimit(int point) {
        return Math.min(point, 800);
    }

    public int yLimit(int point) {
        if (point >= 350) return 348;
        else if (point < 0) return 0;
        else return point;
    }

    protected void applyLimits() {
        if (!limited) {
            x1 = xLimit(x1);
            x2 = xLimit(x2);
            y1 = yLimit(y1);
            y2 = yLimit(y2);
        }
    }

    protected void setDrawingColor(Graphics g) {
        g.setColor(color);
    }

    abstract void draw(Graphics g);
}