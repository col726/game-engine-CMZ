package main;

import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;

public class DemoGame {

	private boolean quit = false;
	private int time = SDL_GetTicks();
	private int REDRAWING_PERIOD = 20;
	private int MAX_FRAME_SKIP = 10;
	
	/**
	 * @param args
	 */
	public void main(String[] args) {
		// TODO Auto-generated method stub
		
		CMZEngine DemoEngine = new CMZEngine();
		
		boolean timeForUpdatingAI = true;
		boolean timeForUpdatingPhysics = true;
		boolean timeForRendering = true;
		
		
		Object I;
		
		DemoEngine.Init();
		
		while(!quit)
		{
			pollForOSMessages();
			I = getInput();
			
			DemoEngine.UpdateAI(I);
		
			DemoEngine.UpdatePhysics(I);
			updateStatistics();

			FPSControl(DemoEngine);
			
			SDL_Delay(1);
		}

	}

	private static boolean getInput() {
		// TODO Auto-generated method stub
		
		return false;
	}
	
	private void FPSControl(CMZEngine game) {
		int act_time = SDL_GetTicks();
		int frames = 0;
		boolean need_to_redraw = true;
		
		while(act_time - time >= REDRAWING_PERIOD && frames<MAX_FRAME_SKIP) {
			time += REDRAWING_PERIOD;
			keyboard->cycle();
			if (!game->cycle(k)) quit = true;
			act_time = SDL_GetTicks();
			need_to_redraw = true;
			frames++;
		}
		if (time < act_time) time = act_time;
		
		if(need_to_redraw)
		{
			game.Render();
			need_to_redraw = false;
		}
	}

	private static void updateStatistics() {
		// TODO Auto-generated method stub
		
	}

	private static void pollForOSMessages() {
		// TODO Auto-generated method stub
		while ( event = SDL_PollEvent() ) {
			switch ( event.type ) {
				case SDL_KEYDOWN:
					if (event.key.keysym.sym == SDLK_F12) {
						quit = true;
					}
					break;
				case SDL_MOUSEBUTTONDOWN:
					game->MouseClick(event.button.x,event.button.y);
					break;
				case SDL_QUIT:
					quit = true;
					break;
			}
		}
	}

}
