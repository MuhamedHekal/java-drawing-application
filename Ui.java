import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
public class Ui extends MyPanel{
    public static ArrayList<Shape> uiObj= new ArrayList<>();
    public static int currentColor;
    public static String currentShape = "Line";
    public static boolean currentfilled;
    public Ui(Graphics g, int frameHeight, int frameWidth){
        
        // setLayout(null);
        Shape.limited = true;
        // System.out.println("ui limited : "+ Shape.limited);
        Font f = new Font("Arial", Font.BOLD ,20 );
        Font f2 = new Font("Arial", Font.BOLD ,10 );
        g.setFont(f);
        // draw the bottom rectangle
        Shape bigrec = new Rectangle(0, 350 ,800,470 ,Shape.BLACK,false,true);
        
        bigrec.draw(g);
        // draw the color rectangle
        g.drawString("Color", 100, 380);
        Shape colorrec = new Rectangle(10, 360 ,250,460 ,Shape.BLACK,false,true);
        colorrec.draw(g);
            // generate color oval 
            Shape redcircle = new Oval(30, 400 ,80,450 ,Shape.RED,true,true);
            redcircle.draw(g);
            
            uiObj.add(redcircle);

            Shape bluecircle = new Oval(110, 400 ,160,450 ,Shape.BLUE,true,true);
            bluecircle.draw(g);
            
            uiObj.add(bluecircle);

            Shape greencircle = new Oval(190, 400 ,240,450 ,Shape.GREEN,true,true);
            greencircle.draw(g);
            
            uiObj.add(greencircle);
        
            
        // draw the shape rectangle
        g.setColor(Color.BLACK);
        g.drawString("Shape", 360, 380);
        Shape shaperec = new Rectangle(270, 360 ,510,460 ,0,false,true);
        shaperec.draw(g);
        
            // generate shapes
            Shape filledRecShape = new Rectangle(290, 400 ,360,450 ,0,true,true);
            filledRecShape.draw(g);
            uiObj.add(filledRecShape);
            Shape filledOvalShape = new Oval(380, 400 ,450,450 ,0,true,true);
            filledOvalShape.draw(g);
            uiObj.add(filledOvalShape);

            Shape filledlineShape = new Line(470, 400 ,500,450 ,0,true,true);
            filledlineShape.draw(g);
            uiObj.add(filledlineShape);
            
            

        // draw free hand button
        g.setFont(f2);
        g.drawString("Free hand", 540, 375);
        Shape freehand = new Rectangle(530, 360 ,600,380 ,0,false,true);
        freehand.draw(g);
        uiObj.add(freehand);
        // draw eraser button
        g.setFont(f2);
        g.drawString("Eraser", 550, 415);
        Shape Eraser = new Rectangle(530, 400 ,600,420 ,0,false,true);
        Eraser.draw(g);
        uiObj.add(Eraser);

        // draw Clear button
        g.setFont(f2);
        g.drawString("Clear", 550, 455);
        Shape Clear = new Rectangle(530, 440 ,600,460 ,0,false,true);
        Clear.draw(g);
        uiObj.add(Clear);
        // draw Fillshape rectangle
        g.setFont(f2);
        g.drawString("Fill Shape", 675, 375);
        Shape fillShape= new Rectangle(650, 360 ,670,380 ,0,currentfilled,true);
        fillShape.draw(g);
        uiObj.add(fillShape);
        // draw Dotted shape rectangle
        g.setFont(f2);
        g.drawString("Dotted Shape", 675, 415);
        Shape dottedShape = new Rectangle(650, 400 ,670,420 ,0,false,true);
        dottedShape.draw(g);
        uiObj.add(dottedShape);
        
        
        Shape.limited = false;                             
    }
    
}
