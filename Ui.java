import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Ui {
    public static ArrayList<Shape> uiObj = new ArrayList<>();
    public static Color currentColor = Color.RED;
    public static String currentShape = "Line";
    public static boolean currentFilled = false;

    public Ui(Graphics g) {
        Shape.limited = true;
        Font f = new Font("Arial", Font.BOLD, 20);
        Font f2 = new Font("Arial", Font.BOLD, 10);
        g.setFont(f);

        // Draw the bottom rectangle
        Shape bigrec = new Rectangle(0, 350, 800, 470, Color.BLACK, false);
        bigrec.draw(g);

        // Draw the color rectangle
        g.drawString("Color", 100, 380);
        Shape colorrec = new Rectangle(10, 360, 250, 460, Color.BLACK, false);
        colorrec.draw(g);

        // Generate color ovals
        Shape redCircle = new Oval(30, 400, 80, 450, Color.RED, true);
        redCircle.draw(g);
        uiObj.add(redCircle);

        Shape blueCircle = new Oval(110, 400, 160, 450, Color.BLUE, true);
        blueCircle.draw(g);
        uiObj.add(blueCircle);

        Shape greenCircle = new Oval(190, 400, 240, 450, Color.GREEN, true);
        greenCircle.draw(g);
        uiObj.add(greenCircle);

        // Draw the shape rectangle
        g.setColor(Color.BLACK);
        g.drawString("Shape", 360, 380);
        Shape shapeRec = new Rectangle(270, 360, 510, 460, Color.BLACK, false);
        shapeRec.draw(g);

        // Generate shapes
        Shape filledRecShape = new Rectangle(290, 400, 360, 450, Color.BLACK, true);
        filledRecShape.draw(g);
        uiObj.add(filledRecShape);

        Shape filledOvalShape = new Oval(380, 400, 450, 450, Color.BLACK, true);
        filledOvalShape.draw(g);
        uiObj.add(filledOvalShape);

        Shape filledLineShape = new Line(470, 400, 500, 450, Color.BLACK, true);
        filledLineShape.draw(g);
        uiObj.add(filledLineShape);

        // Draw free hand button
        g.setFont(f2);
        g.drawString("Free hand", 540, 375);
        Shape freeHand = new Rectangle(530, 360, 600, 380, Color.BLACK, false);
        freeHand.draw(g);
        uiObj.add(freeHand);

        // Draw eraser button
        g.setFont(f2);
        g.drawString("Eraser", 550, 415);
        Shape eraser = new Rectangle(530, 400, 600, 420, Color.BLACK, false);
        eraser.draw(g);
        uiObj.add(eraser);

        // Draw Clear button
        g.setFont(f2);
        g.drawString("Clear", 550, 455);
        Shape clear = new Rectangle(530, 440, 600, 460, Color.BLACK, false);
        clear.draw(g);
        uiObj.add(clear);

        // Draw Fill shape rectangle
        g.setFont(f2);
        g.drawString("Fill Shape", 675, 375);
        Shape fillShape = new Rectangle(650, 360, 670, 380, Color.BLACK, currentFilled);
        fillShape.draw(g);
        uiObj.add(fillShape);

        Shape.limited = false;
    }
    public static String getColorName(Color color) {
		if (color.equals(Color.RED)) {
			return "Red";
		} else if (color.equals(Color.BLUE)) {
			return "Blue";
		} else if (color.equals(Color.GREEN)) {
			return "Green"; 
		} else if (color.equals(Color.WHITE)) {
			return "White";
		} else {
			return "Unknown";
		}
	}
}
