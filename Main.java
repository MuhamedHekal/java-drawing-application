import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
class MyPanel extends JPanel{
	Shape r ;
	// String Selected = "Oval";
	public MyPanel(){
		Shape.limited = true;
		if("Oval".equals(Ui.currentShape)){
			r = new Oval();
			
		}else if("Rectangle".equals(Ui.currentShape)) {
			r = new Rectangle();
			
		}else if ("Line".equals(Ui.currentShape)){
			r = new Line();}

		else if ("FreeHand".equals(Ui.currentShape)){
			r = new FreeHand();}
			
		//history = new ArrayList<>();



		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
			
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
				r.setx2(e.getPoint().x);
				r.sety2(e.getPoint().y);
				if("Oval".equals(Ui.currentShape)){
					r.history.add(r);	
					r = new Oval();	
				}else if ("Rectangle".equals(Ui.currentShape)){
					r.history.add(r);	
					r = new Rectangle();	
				}else if ("Line".equals(Ui.currentShape)){
					r.history.add(r);	
					r = new Line();	
				}
				
			}
				
			
		
			
		});
		addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Set the last point to the current mouse position
				if ("FreeHand".equals(Ui.currentShape)){
					r.setx2(e.getX());
					r.sety2(e.getY());
					repaint();
					r.freehand.add(r);
					r = new FreeHand();	
					r.setcolor();
					r.setx1(e.getX());
					r.sety1(e.getY());
					
				}else{
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
	public void paint(Graphics g){
		super.paint(g);
		switch (Ui.currentColor) {
            case 0 -> g.drawString("Black ", 15, 15);
            case 1 -> g.drawString("Red ", 15, 15);
            case 2 -> g.drawString("Blue ", 15, 15);
            case 3 -> g.drawString("Green ", 15, 15);
        default -> throw new AssertionError();
        }
        g.drawString(Ui.currentShape, 15, 30);
		new Ui(g, getHeight(), getWidth());
		
		if(!"FreeHand".equals(Ui.currentShape)){
			r.draw(g);
		}
		for (Shape d : r.history){
			d.draw(g);
			
		}
		// r.draw(g);
		for (Shape s : r.freehand){
			s.draw(g);
		}
		// g.drawString("Hello", 100, 100);
		// g.drawRect(0, getHeight() - getHeight()/2/3 , getWidth(), getHeight()/3);
		
		
		
		
	}

}

public class Main{
	public static void main (String[] args){
		
		JFrame frame = new JFrame();
		frame.setContentPane(new MyPanel());
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setVisible(true);
	}

}

