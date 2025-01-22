import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
class MyPanel extends JPanel{
	Shape r ;
	String Selected = "Oval";
	public MyPanel(){
		Shape.limited = true;
		if("Oval".equals(Selected)){
			r = new Oval();
			
		}else if("Rectangle".equals(Selected)) {
			r = new Rectangle();
			
		}else{
			r = new Line();
			
			
		}
		//history = new ArrayList<>();
		addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e){
				r.setx1(e.getX());
				r.sety1(e.getY());
				r.setcolor();
				System.out.println("mouse pressed x in ui : " + e.getX() );
                System.out.println("mouse pressed y in ui : " + e.getY() );
				
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
				if("Oval".equals(Selected)){
					r.history.add(r);	
					r = new Oval();	
				}else if ("Rectangle".equals(Selected)){
					r.history.add(r);	
					r = new Rectangle();	
				}else{
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
		for (Shape d : r.history){
			d.draw(g);
		}
		// g.drawString("Hello", 100, 100);
		// g.drawRect(0, getHeight() - getHeight()/2/3 , getWidth(), getHeight()/3);
		new Ui(g, getHeight(), getWidth());
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

