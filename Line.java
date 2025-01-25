import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
    public Line() {
        super();
    }

    public Line(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color, filled);
    }

    @Override
    public void draw(Graphics g) {
        applyLimits();
        setDrawingColor(g);
        g.drawLine(x1, y1, x2, y2);
    }
}