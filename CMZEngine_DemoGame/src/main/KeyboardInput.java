package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput extends Core implements KeyListener {
	public static void main(String[] args) {
		new KeyboardInput().run();
	}
	
	private String mess = "";
	
	public void init() {
		super.init();
		Window w = s.getFullScreenWindow();
		w.setFocusTraversalKeysEnabled(false);
		w.addKeyListener(this);
		mess = "Press escape to exit";
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_ESCAPE)
		{
			stop();
		}
		else
		{
			mess = "Pressed : " + KeyEvent.getKeyText(keyCode);
			e.consume();
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		mess = "Released : " + KeyEvent.getKeyText(keyCode);
		e.consume();
	}

	public void keyTyped(KeyEvent e) {
		e.consume();
	}

	public synchronized void draw(Graphics2D g) {
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(mess, 30, 30);
	}
}
