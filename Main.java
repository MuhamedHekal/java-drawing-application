import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
class MyPanel extends JPanel{
	Shape r ;
	// String Selected = "Oval";
	public MyPanel(){
		setBackground(Color.WHITE);
		Shape.limited = true;
		if("Oval".equals(Ui.currentShape)){
			r = new Oval();
			
		}else if("Rectangle".equals(Ui.currentShape)) {
			r = new Rectangle();
			
		}else if ("Line".equals(Ui.currentShape)){
			r = new Line();}

		else if ("FreeHand".equals(Ui.currentShape)){
			r = new FreeHand();}
		else if ("Eraser".equals(Ui.currentShape)){
			r = new Eraser();}
		
		//history = new ArrayList<>();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				if (isWithinFillShapeButton(e.getPoint())) {
					Ui.currentfilled = !Ui.currentfilled; // Toggle the filled state
					Graphics g = getGraphics();
					if (Ui.currentfilled){
						g.setColor(Color.BLACK);
						g.fillRect(650, 360 ,20,20);
					}
					else{
						g.setColor(Color.WHITE);
                    	g.fillRect(650, 360 ,20,20);
					}
					
				}
				
				
				
				if ("Clear".equals(r.type)){
					Graphics g = getGraphics();
					g.setColor(Color.white);
                    g.fillRect(0, 0, 800, 350);
					r.history.add(new Rectangle(0,0,800,350,-1,true,true));
				
				}

				r.setx1(e.getPoint().x);
				r.sety1(e.getPoint().y);
				r.setcolor();
				r.settype();
			
			}
			@Override
			public void mouseClicked(MouseEvent e){
			}
			@Override
			public void mouseExited(MouseEvent e){
			}
			@Override
			public void mouseEntered(MouseEvent e){
			}
			@Override
			public void mouseReleased(MouseEvent e){
				// if the selected is Rectangle
				r.setfilled();
				r.setx2(e.getPoint().x);
				r.sety2(e.getPoint().y);
				r.history.add(r);	
				if(null != Ui.currentShape)switch (Ui.currentShape) {
                                case "Oval" -> r = new Oval();
                                case "Rectangle" -> r = new Rectangle();
                                case "Line" -> r = new Line();
                                case "Freehand" -> r = new FreeHand();
                                case "Eraser" -> r = new Eraser();
                                default -> {
                                    }
                            }
				
			}
				
		});
		addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Set the last point to the current mouse position
				if (("FreeHand".equals(Ui.currentShape)) || ("Eraser".equals(Ui.currentShape)))  {
					r.setx2(e.getX());
					r.sety2(e.getY());
					
					repaint();
					
					if ("FreeHand".equals(Ui.currentShape)){
						r.history.add(r);
						r = new FreeHand();
					}else{
						r.history.add(r);
						r = new Eraser();
					}
					r.setcolor();
					r.setx1(e.getX());
					r.sety1(e.getY());
					
				}else{
					r.setfilled();
					r.setx2(e.getX());
					r.sety2(e.getY());
					repaint();
				}

				
				
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                
            }
        });
	}
	private boolean isWithinFillShapeButton(Point point) {
		// Define the bounds of the "Fill Shape" button
		int x1 = 650, y1 = 360, x2 = 670, y2 = 380;
		return point.x >= x1 && point.x <= x2 && point.y >= y1 && point.y <= y2;
	}
	public void paint(Graphics g){
		super.paint(g);
		new Ui(g, getHeight(), getWidth());
		switch (Ui.currentColor) {
            case 0 -> g.drawString("Black ", 15, 15);
            case 1 -> g.drawString("Red ", 15, 15);
            case 2 -> g.drawString("Blue ", 15, 15);
            case 3 -> g.drawString("Green ", 15, 15);
			case -1 -> g.drawString("White ", 15, 15);
        default -> throw new AssertionError();
        }
        g.drawString(Ui.currentShape, 15, 30);
		for (Shape s : r.history){
			s.draw(g);
			
		}
		if((!"FreeHand".equals(Ui.currentShape)) && (!"Eraser".equals(Ui.currentShape))){
			r.draw(g);
		}
		
		
		
		
	}

}

public class Main{
	public static void main (String[] args){
		
		JFrame frame = new JFrame();
		frame.setContentPane(new MyPanel());
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setVisible(true);
	}

}

