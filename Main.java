import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
			r = new Line();
			
			
		}
		//history = new ArrayList<>();
		addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e){
				r.setx1(e.getX());
				r.sety1(e.getY());
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
		addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Set the last point to the current mouse position
				r.setx2(e.getPoint().x);
				r.sety2(e.getPoint().y);
				repaint();
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
		
		for (Shape d : r.history){
			d.draw(g);
		}
		// g.drawString("Hello", 100, 100);
		// g.drawRect(0, getHeight() - getHeight()/2/3 , getWidth(), getHeight()/3);
		
		r.draw(g);
		
		
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

