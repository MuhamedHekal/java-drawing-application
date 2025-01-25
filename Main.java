import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class MyPanel extends JPanel {
    Shape currentShape;
    private Point startPoint;

    public MyPanel() {
        setBackground(Color.WHITE);
        currentShape = createShape(Ui.currentShape);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                currentShape.setCoordinates(startPoint.x, startPoint.y, startPoint.x, startPoint.y);
                currentShape.setColor(Ui.currentColor);
                currentShape.setFilled(Ui.currentFilled);
                handleMouseClick(e.getPoint()); // Handle UI element clicks
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
                currentShape.setCoordinates(startPoint.x, startPoint.y, e.getX(), e.getY());
                Shape.history.add(currentShape);
                repaint();
                currentShape = createShape(Ui.currentShape);
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (("FreeHand".equals(Ui.currentShape)) || ("Eraser".equals(Ui.currentShape)))  {
                    currentShape.setCoordinates(startPoint.x, startPoint.y, e.getX(), e.getY());
                    repaint();
                    Shape.history.add(currentShape);
                    currentShape = createShape(Ui.currentShape);
                    startPoint = e.getPoint();
                }else{
                    currentShape.setCoordinates(startPoint.x, startPoint.y, e.getX(), e.getY());
                    repaint();
                }
            }
        });

    }

    

    private Shape createShape(String shapeType) {
        return switch (shapeType) {
            case "Oval" -> new Oval();
            case "Rectangle" -> new Rectangle();
            case "Line" -> new Line();
            case "FreeHand" -> new FreeHand();
            case "Eraser" -> new Eraser();
            default -> new Line();
        };
    } 

    private boolean isWithinBounds(Point point, int x1, int y1, int x2, int y2) {
        return point.x >= x1 && point.x <= x2 && point.y >= y1 && point.y <= y2;
    }
    private void handleMouseClick(Point point) {
        // Check if the click is within the "Fill Shape" button
        if (isWithinBounds(point, 650, 360, 670, 380)) {
            Ui.currentFilled = !Ui.currentFilled;
        }

        // Check if the click is within the "Red Color" circle
        else if (isWithinBounds(point, 30, 400, 80, 450)) {
            Ui.currentColor = Color.RED;
        }

        // Check if the click is within the "Blue Color" circle
        else if (isWithinBounds(point, 110, 400, 160, 450)) {
            Ui.currentColor = Color.BLUE;
        }

        // Check if the click is within the "Green Color" circle
        else if (isWithinBounds(point, 190, 400, 240, 450)) {
            Ui.currentColor = Color.GREEN;
        }

        // Check if the click is within the "Rectangle" shape button
        else if (isWithinBounds(point, 290, 400, 360, 450)) {
            Ui.currentShape = "Rectangle";
        }

        // Check if the click is within the "Oval" shape button
        else if (isWithinBounds(point, 380, 400, 450, 450)) {
            Ui.currentShape = "Oval";
        }

        // Check if the click is within the "Line" shape button
        else if (isWithinBounds(point, 470, 400, 500, 450)) {
            Ui.currentShape = "Line";
        }

        // Check if the click is within the "FreeHand" button
        else if (isWithinBounds(point, 530, 360, 600, 380)) {
            Ui.currentShape = "FreeHand";
        }

        // Check if the click is within the "Eraser" button
        else if (isWithinBounds(point, 530, 400, 600, 420)) {
            Ui.currentShape = "Eraser";
        }

        // Check if the click is within the "Clear" button
        else if (isWithinBounds(point, 530, 440, 600, 460)) {
            Graphics g = getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 800, 350);
            Shape.history.add(new Rectangle(0, 0, 800, 350, Color.WHITE, true));
        }

        repaint(); // Refresh the UI
    }
	
    @Override
    public void paint(Graphics g) {
        super.paint(g);
		
        new Ui(g);
        for (Shape s : currentShape.history){
			s.draw(g);
			
		}
        currentShape.draw(g);
		String colorName = Ui.getColorName(Ui.currentColor);
		g.drawString(colorName, 15, 15);
        g.drawString(Ui.currentShape, 15, 30);
    }

}

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new MyPanel());
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setVisible(true);
    }
}