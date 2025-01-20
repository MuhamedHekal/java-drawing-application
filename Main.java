import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
class MyPanel extends JPanel{
	Shape r ;
	ArrayList<Shape> history;
	public MyPanel(){
		r = new Rectangle();
		history = new ArrayList<>();
		addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e){
				r.setx1(e.getX());
				r.sety1(e.getY());
				
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
				Shape temp = new Rectangle(r.getX().get(0), r.getY().get(0), r.getX().get(1), r.getY().get(1));
				history.add(temp);
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
		// g.drawString("Hello", 100, 100);
		// g.drawRect(0, getHeight() - getHeight()/2/3 , getWidth(), getHeight()/3);
		r.draw(g);
		
		for (Shape d : history){
			d.draw(g);
		}
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

