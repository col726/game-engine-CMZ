package main;
import java.awt.*;
import java.awt.event.*;

import main.Levels.*;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import javax.media.opengl.*;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;

import javax.swing.ImageIcon;

public class DemoGame extends Core {
	private int time = 0;
	private final int REDRAWING_PERIOD = 20;
	private final int MAX_FRAME_SKIP = 10;
	public CMZEngine DemoEngine;
	
	public Toolkit toolkit;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DemoGame().run();
	}
	
	public void init() {
		super.init();
		Window w = s.getFullScreenWindow();
		w.addKeyListener(this);
		DemoEngine = new CMZEngine();
	}
	
	protected String enginemess = "";
	
	public void gameLoop() {
		
		GameLevel Level1 = new LevelOne();
		DemoEngine.addLevel(Level1);
		
		DemoEngine.Init();
		
		
		
		while(running)
		{
			//quit = pollForOSMessages();
			String gameAction = GameAction;
			
			DemoEngine.UpdateAI(gameAction);
			mess += "\n--AI Updated";
			
			DemoEngine.UpdatePhysics(gameAction);
			mess += "\n--Physics Updated";
			updateStatistics();
			DemoEngine.UpdateSound();
			mess += "\n--Frames Update";
			
			//enginemess = DemoEngine.getUnreadMessages();
			
			Graphics2D g = s.getGraphics();
			draw(g);
			DemoEngine.Render(g);
			g.dispose();
			s.update();
		}

	}
	
	public synchronized void draw(Graphics2D g) {
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		drawString(g, "Press ESC to exit...", 10, 10);
		g.drawImage(new ImageIcon("res/images/game_background.jpg").getImage(), 0, 0, s.getWidth(), s.getHeight(), null);
		//drawString(g, "Game Messages\n" + mess, 40, 50);
		//drawString(g, "Engine Messages\n" + enginemess, 300, 50);
	}

	

	private void updateStatistics() {
		// TODO Auto-generated method stub
		
	}

	//Note: pollForOSMessages returns true if the game loop should exit
	private boolean pollForOSMessages() {
		/*while ( event = SDL_PollEvent() ) {
			switch ( event.type ) {
				case SDL_KEYDOWN:
					if (event.key.keysym.sym == SDLK_F12) {
						return true;
					}
					break;
				case SDL_MOUSEBUTTONDOWN:
					game->MouseClick(event.button.x,event.button.y);
					break;
				case SDL_QUIT:
					quit = true;
			}
		}*/
		return false;
	}

}
