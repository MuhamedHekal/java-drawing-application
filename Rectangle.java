
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
   
    public Rectangle(){
        
    }
    public Rectangle(int x1, int y1, int x2, int y2,int color){
        super(x1,y1,x2,y2,color);
        
    }
    
   
    public void draw(Graphics g) {
        int x = Math.min(x1, x2); // Top-left x-coordinate
        int y = Math.min(y1, y2); // Top-left y-coordinate
        int width = Math.abs(x2 - x1); // Absolute width
        int height = Math.abs(y2 - y1); // Absolute height
        switch (color) {
            case 0:
                g.setColor(Color.black);
                break;
            case 1:
                g.setColor(Color.red);
                break;
            case 2:
                g.setColor(Color.blue);
                break;
            case 3:
            g.setColor(Color.green);
            break;
        default:
                throw new AssertionError();
        }
        g.drawRect(x, y, width, height); // Draw rectangle
    }
}
