import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTest extends Core implements KeyListener{
	public static void main(String[] args){
		new KeyTest().run();
	}
	private String msg = "";
	
	//init from superclass
	public void init(){
		super.init();
		Window w = s.getFullScreenWindow();
		w.setFocusTraversalKeysEnabled(false);
		w.addKeyListener(this);
		msg = "Press esc to Exit";
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
	
	public synchronized void draw(Graphics2D g){
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWitdth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(msg, 30, 30);
		
	}

}