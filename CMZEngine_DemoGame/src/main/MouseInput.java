package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseInput extends Core implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {
	public static void main(String[] args) {
		new MouseInput().run();
	}
	
	private String mess = "";

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
	
	public void init() {
		super.init();
		Window w = s.getFullScreenWindow();
		w.addMouseListener(this);
		w.addMouseMotionListener(this);
		w.addMouseWheelListener(this);
		w.addKeyListener(this);
	}
	
	public synchronized void draw(Graphics2D g) {
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(mess, 40, 50);
	}
	
	public void mousePressed(MouseEvent e) {
		mess = "You pressed down the mouse";
	}
	
	public void mouseReleased(MouseEvent e) {
		mess = "You released the mouse";
	}
	
	public void mouseClicked(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
	
	public void mouseDragged(MouseEvent e) {
		mess = "You are dragging the mouse";
	}
	
	public void mouseMoved(MouseEvent e) {
		mess = "You are moving the mouse";
	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		mess = "You are moving the mouse wheel";
	}
}
