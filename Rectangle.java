
import java.awt.Graphics;

public class Rectangle extends Shape {
    public Rectangle(){
        
    }
    public Rectangle(int x1, int y1, int x2, int y2){
        super(x1,y1,x2,y2);
    }
    
   
    public void draw(Graphics g) {
        int x = Math.min(x1, x2); // Top-left x-coordinate
        int y = Math.min(y1, y2); // Top-left y-coordinate
        int width = Math.abs(x2 - x1); // Absolute width
        int height = Math.abs(y2 - y1); // Absolute height
    
        g.drawRect(x, y, width, height); // Draw rectangle
    }
}
