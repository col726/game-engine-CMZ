package main;

import java.awt.*;
import java.awt.event.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import javax.media.opengl.*;

public class DemoGame extends Core {
	private int time = 0;
	private final int REDRAWING_PERIOD = 20;
	private final int MAX_FRAME_SKIP = 10;
	private boolean quit2 = false;
	
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
	}
	
	protected String enginemess = "";
	
	public void gameLoop() {
		CMZEngine DemoEngine = new CMZEngine();
		
		boolean timeForUpdatingAI = true;
		boolean timeForUpdatingPhysics = true;
		boolean timeForRendering = true;
		
		boolean quit = false;
		
		
		Object I;
		
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

			FPSControl(DemoEngine);
			mess += "\n--Frames Update";
			
			//enginemess = DemoEngine.getUnreadMessages();
			
			Graphics2D g = s.getGraphics();
			draw(g);
			DemoEngine.Render(g);
			g.dispose();
			s.update();
			
			SDL_Delay(1);
		}

	}
	
	public synchronized void draw(Graphics2D g) {
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		drawString(g, "Press ESC to exit...", 10, 10);
		
		//drawString(g, "Game Messages\n" + mess, 40, 50);
		//drawString(g, "Engine Messages\n" + enginemess, 300, 50);
	}

	private void SDL_Delay(int i) {
		// TODO Auto-generated method stub
		
	}

	private int SDL_GetTicks() {
		// TODO Auto-generated method stub
		return 60;
	}

	private boolean getInput() {
		// TODO Auto-generated method stub
		
		return false;
	}
	
	private void FPSControl(CMZEngine game) {
		int act_time = SDL_GetTicks();
		int frames = 0;
		boolean need_to_redraw = true;
		
		while(act_time - time >= REDRAWING_PERIOD && frames<MAX_FRAME_SKIP) 
		{
			time += REDRAWING_PERIOD;
			
			//keyboard->cycle();
			//if (!game->cycle(k)) 
				//quit = true;
			act_time = SDL_GetTicks();
			need_to_redraw = true;
			frames++;
		}
		
		if (time < act_time)
			time = act_time;
		
		if(need_to_redraw)
		{
			//game.Render();
			need_to_redraw = false;
		}
	}

	private void updateStatistics() {
		// TODO Auto-generated method stub
		
	}

	//Note: pollForOSMessages returns true if the game loop should exit
	private boolean pollForOSMessages() {
		// TODO Auto-generated method stub
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
