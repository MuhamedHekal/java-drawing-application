import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
    public Rectangle() {
        super();
    }

    public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color, filled);
    }

    @Override
    public void draw(Graphics g) {
        applyLimits();
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        setDrawingColor(g);
        if (filled) g.fillRect(x, y, width, height);
        else g.drawRect(x, y, width, height);
    }
}