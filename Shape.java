import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
abstract class Shape {
    protected int x1;
    protected int x2;
    protected int y1;
    protected int y2;
    protected int color ;
    // protected String type ;
    protected boolean filled;
    protected boolean dotted;
    public static boolean limited = true;
    public static final int RED = 1;
    public static final int BLUE = 2;
    public static final int GREEN = 3;
    public static final int BLACK = 0;
    static ArrayList<Shape> history = new ArrayList<>();
    static ArrayList<Shape> freehand = new ArrayList<>();

    public Shape(){
        
    }
    public Shape(int x1, int y1, int x2, int y2, boolean filled, boolean dotted){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.filled = filled;
        this.dotted = dotted;
       
    }
    public Shape(int x1, int y1, int x2, int y2,int color, boolean filled, boolean dotted){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
        this.filled = filled;
        this.dotted = dotted;
        
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
    public void setcolor(){
        
        // int colorOvalDomain = Math.abs(Ui.uiObj.get(0).x1 - Ui.uiObj.get(0).x2)/2;
        int redcenterx = (Ui.uiObj.get(0).x1 + Ui.uiObj.get(0).x2)/2;
        int redcentery = (Ui.uiObj.get(0).y1+Ui.uiObj.get(0).y2)/2;
        double redpressLength = Math.sqrt(Math.pow(redcenterx - x1, 2) + Math.pow(redcentery - y1, 2));

        int bluecenterx = (Ui.uiObj.get(1).x1 + Ui.uiObj.get(1).x2)/2;
        int bluecentery = (Ui.uiObj.get(1).y1+Ui.uiObj.get(1).y2)/2;
        double bluepressLength = Math.sqrt(Math.pow(bluecenterx - x1, 2) + Math.pow(bluecentery - y1, 2));

        int greencenterx = (Ui.uiObj.get(2).x1 + Ui.uiObj.get(2).x2)/2;
        int greencentery = (Ui.uiObj.get(2).y1+Ui.uiObj.get(2).y2)/2;
        double greenpressLength = Math.sqrt(Math.pow(greencenterx - x1, 2) + Math.pow(greencentery - y1, 2));



        if (redpressLength <= 25 ){
           color = RED;
           Ui.currentColor = color;
           
        }
        else if (bluepressLength <= 25 ){
            color = BLUE;
            Ui.currentColor = color;
        }
        else if (greenpressLength <= 25 ){
            color = GREEN;
            Ui.currentColor = color;
        }
        else
            color = Ui.currentColor;
        

        
    }
    public int getcolor(){
        return color;
    }
    public void settype(){
        int RectangleDomain = Math.abs(Ui.uiObj.get(3).x1 - Ui.uiObj.get(3).x2)/2;    
        int Reccenterx = (Ui.uiObj.get(3).x1 + Ui.uiObj.get(3).x2)/2;
        int Reccentery = (Ui.uiObj.get(3).y1+Ui.uiObj.get(3).y2)/2;
        double RecpressLength = Math.sqrt(Math.pow(Reccenterx - x1, 2) + Math.pow(Reccentery - y1, 2));

        int OvalangleDomain = Math.abs(Ui.uiObj.get(4).x1 - Ui.uiObj.get(4).x2)/2;
        int Ovalcenterx = (Ui.uiObj.get(4).x1 + Ui.uiObj.get(4).x2)/2;
        int Ovalcentery = (Ui.uiObj.get(4).y1+Ui.uiObj.get(4).y2)/2;
        double OvalpressLength = Math.sqrt(Math.pow(Ovalcenterx - x1, 2) + Math.pow(Ovalcentery - y1, 2));

        int LineangleDomain = Math.abs(Ui.uiObj.get(5).x1 - Ui.uiObj.get(5).x2)/2;
        int Linecenterx = (Ui.uiObj.get(5).x1 + Ui.uiObj.get(5).x2)/2;
        int Linecentery = (Ui.uiObj.get(5).y1+Ui.uiObj.get(5).y2)/2;
        double LinepressLength = Math.sqrt(Math.pow(Linecenterx - x1, 2) + Math.pow(Linecentery - y1, 2));

        int FHangleDomain = Math.abs(Ui.uiObj.get(6).x1 - Ui.uiObj.get(6).x2)/2;
        int FHcenterx = (Ui.uiObj.get(6).x1 + Ui.uiObj.get(6).x2)/2;
        int FHcentery = (Ui.uiObj.get(6).y1+Ui.uiObj.get(6).y2)/2;
        double FHpressLength = Math.sqrt(Math.pow(FHcenterx - x1, 2) + Math.pow(FHcentery - y1, 2));

        int EangleDomain = Math.abs(Ui.uiObj.get(7).x1 - Ui.uiObj.get(7).x2)/2;
        int Ecenterx = (Ui.uiObj.get(7).x1 + Ui.uiObj.get(7).x2)/2;
        int Ecentery = (Ui.uiObj.get(7).y1+Ui.uiObj.get(7).y2)/2;
        double EpressLength = Math.sqrt(Math.pow(Ecenterx - x1, 2) + Math.pow(Ecentery - y1, 2));


        if (RecpressLength <= RectangleDomain ){
           Ui.currentShape ="Rectangle";
           
           
        }
        else if (OvalpressLength <= OvalangleDomain ){
            Ui.currentShape ="Oval";
            
        }
        else if (LinepressLength <= LineangleDomain ){
            Ui.currentShape ="Line";
            
        }else if (FHpressLength <= FHangleDomain){
            Ui.currentShape = "FreeHand";
            

        }else if (EpressLength <= EangleDomain){
            Ui.currentShape = "Eraser";
            
        }
    

        
    }
    public void setfilled(boolean fill){
        this.filled = fill;
    }
    public boolean getfilled(){
        return this.filled;
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
    public int xLimit(int point){
        if(point > 800)
            return 800;
        else
            return point;
    }
    public int yLimit(int point){
        if(point > 350)
            return 350;
        else if (point < 0)
            return 0;
        else 
            return point;
    }
    abstract void draw(Graphics g);
    
}
