
import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
    public Line(){
        
    }
    public Line(int x1, int y1, int x2, int y2, int color ,boolean filled,boolean dotted){
        super(x1,y1,x2,y2,color,filled,dotted);
        
    }
    public void draw(Graphics g){
        if(limited == false){
        x1 = xLimit(x1);
        x2 = xLimit(x2);
        y1 = yLimit(y1);
        y2 = yLimit(y2);
        }
        switch (color) {
            case 0 -> g.setColor(Color.black);
            case 1 -> g.setColor(Color.red);
            case 2 -> g.setColor(Color.blue);
            case 3 -> g.setColor(Color.green);
            case -1 -> g.setColor(Color.white);
        default -> throw new AssertionError();
        }
        
         g.drawLine(x1, y1, x2, y2);
       
    }
    
}
