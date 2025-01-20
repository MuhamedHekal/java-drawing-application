import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
abstract class Shape {
    protected int x1;
    protected int x2;
    protected int y1;
    protected int y2;
    protected String color;
    protected boolean filled;
    protected boolean dotted;

    public Shape(){

    }
    public Shape(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

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
