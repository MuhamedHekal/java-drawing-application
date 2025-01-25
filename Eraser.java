import java.awt.Color;
import java.awt.Graphics;

public class Eraser extends Shape {
    public Eraser() {
        super();
        setColor(Color.WHITE);
    }

    public Eraser(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color, filled);
    }

    @Override
    public void draw(Graphics g) {
        applyLimits();
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        g.setColor(Color.WHITE);
        g.fillOval(x-29, y-29, 30, 30);
    }
}