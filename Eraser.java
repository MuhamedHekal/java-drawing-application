import java.awt.Color;
import java.awt.Graphics;

public class Eraser extends Shape {
    public Eraser() {
       
    }

    public Eraser(int x1, int y1, int x2, int y2, int color, boolean filled, boolean dotted) {
        super(x1, y1, x2, y2, color, filled, dotted);
    }

    @Override
    public void draw(Graphics g) {
        if(limited == false){
        x1 = xLimit(x1);
        x2 = xLimit(x2);
        y1 = yLimit(y1);
        y2 = yLimit(y2);
        }
        int x = Math.min(x1, x2); // Top-left x-coordinate
        int y = Math.min(y1, y2); // Top-left y-coordinate
        int width = Math.abs(x2 - x1); // Absolute width
        int height = Math.abs(y2 - y1); // Absolute height
        
        g.setColor(Color.white);
        g.fillOval(x-29, y-29, 30, 30);
        
        
    }
}