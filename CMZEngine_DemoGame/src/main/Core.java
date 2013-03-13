package main;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public abstract class Core implements KeyListener {
	private static DisplayMode modes[] = {
		new DisplayMode(1366, 768, 32, 0), 
		new DisplayMode(800, 600, 32, 0), 
		new DisplayMode(800, 600, 24, 0), 
		new DisplayMode(800, 600, 16, 0), 
		new DisplayMode(640, 480, 32, 0), 
		new DisplayMode(640, 480, 24, 0), 
		new DisplayMode(640, 480, 16, 0)
	};
	protected boolean running;
	protected ScreenManager s;
	protected String GameAction;//Future Work: make this a list
	
	public void stop() {
		running = false;
	}
	
	public void run() {
		try
		{
			init();
			gameLoop();
		}
		finally
		{
			s.restoreScreen();
		}
	}
	
	public void init() {
		s = new ScreenManager();
		DisplayMode dm = s.findFirstCompatibleMode(modes);
		s.setFullScreen(dm);
		
		Window w = s.getFullScreenWindow();
		w.setFont(new Font("Arial", Font.PLAIN, 14));
		w.setBackground(Color.BLACK);
		w.setForeground(Color.WHITE);
		running = true;
		//w.addKeyListener(this);
	}
	
	public void gameLoop() {
		/*long startTime = System.currentTimeMillis();
		long cumTime = startTime;
		
		while(running)
		{
			long timePassed = System.currentTimeMillis() - cumTime;
			cumTime += timePassed;
			
			update(timePassed);
			
			Graphics2D g = s.getGraphics();
			draw(g);
			g.dispose();
			s.update();
			
			try
			{
				Thread.sleep(20);
			} catch(Exception ex) {}
		}*/
	}
	
	public void update(long timePassed) {
	}
	
	public abstract void draw(Graphics2D g);
	
	protected String mess = "";

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_ESCAPE)
		{
			stop();
		}
		else
		{
			mess = "Pressed : " + KeyEvent.getKeyText(keyCode);
			GameAction= KeyEvent.getKeyText(keyCode);
			e.consume();
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		mess = "Released : " + KeyEvent.getKeyText(keyCode);
		GameAction = "";
		e.consume();
	}

	public void keyTyped(KeyEvent e) {
		e.consume();
	}
	
	protected void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
        {
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
        }
    }
}
