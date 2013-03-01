import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseInput extends Core implements KeyListener,MouseMotionListener, MouseListener, MouseWheelListener {
	public static void main(String[] args){
		new MouseInput().run();
	}
	public String msg = "";

//init from superclass
	public void init(){
		super.init();
		Window w = s.getFullScreenWindow();

		w.addMouseListener(this);
		w.addMouseMotionListener(this);
		w.addMouseWheelListener(this);
		w.addKeyListener(this);
		msg = "Press esc to Exit";
	}
	public synchronized void draw(Graphics2D g){
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWitdth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(msg, 40, 50);
	}	
	
//mouse listener
	public void mousePressed(MouseEvent e){
		msg = "Mouse Pressed: ";
	}
	public void mouseReleased(MouseEvent e){
		msg = "Mouse Released: ";
	}	
	public void mouseClicked(MouseEvent e){
		
	}
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
//mouse motion
	
	public void mouseDragged(MouseEvent e){
		msg = "Mouse Dragged: ";
	}

	public void mouseMoved(MouseEvent e){
		msg = "Mouse Moved: ";
	}
		
	public void mouseWheelMoved(MouseWheelEvent e){
		msg = "Mouse Wheel Moved: ";
	}
//keypressed
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_ESCAPE){
			stop();
		}else{
			msg = "Pressed Key is: " + KeyEvent.getKeyText(keyCode);
			e.consume();  //commits single key
		}
	}
//keyreleased
	public void keyReleased(KeyEvent e){
		int keyCode = e.getKeyCode();
		msg = "Released Key is: " + KeyEvent.getKeyText(keyCode);
		e.consume();  //commits single key
	}
//keytyped	
	public void keyTyped(KeyEvent e){
		e.consume();  //commits single key
	}
	
	
}