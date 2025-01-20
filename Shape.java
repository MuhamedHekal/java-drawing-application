import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
abstract class Shape {
    protected int x1;
    protected int x2;
    protected int y1;
    protected int y2;
    protected int color;
    protected boolean filled;
    protected boolean dotted;
    public static final int RED = 1;
    public static final int BLUE = 2;
    public static final int GREEN = 3;
    public static final int BLACK = 0;

    public Shape(){

    }
    public Shape(int x1, int y1, int x2, int y2, int color){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color= color;
        
    }
    public void setx1(int x1){
        this.x1 = x1;
       
    }
    public void setx2(int x2){
        this.x2 = x2;
    }
    public void sety1(int y1){
        this.y1 = y1;
    }
    public void sety2(int y2){
        this.y2 = y2;
    }
    public void setcolor(int color){
        this.color = color;
    }
    public int getcolor(){
        return color;
    }
    public List<Integer> getX(){
        List<Integer> Xs = new ArrayList<>();
        Xs.add(x1);
        Xs.add(x2);
        return Xs;
    }
    public List<Integer> getY(){
        List<Integer> Ys = new ArrayList<>();
        Ys.add(y1);
        Ys.add(y2);
        return Ys;
    }
    abstract void draw(Graphics g);

}
