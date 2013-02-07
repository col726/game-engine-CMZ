package main;

import java.awt.event.*;

public class DemoGame {

	private boolean quit = false;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CMZEngine DemoEngine = new CMZEngine();
		
		boolean timeForUpdatingAI = true;
		boolean timeForUpdatingPhysics = true;
		boolean timeForRendering = true;
		
		int time = SDL_GetTicks();
		int REDRAWING_PERIOD = 20;
		int MAX_FRAME_SKIP = 10;
		boolean need_to_redraw = true;
		
		Object I;
		
		DemoEngine.Init();
		
		while(!quit)
		{
			pollForOSMessages();
			I = getInput();
			if(timeForUpdatingAI)
				DemoEngine.UpdateAI(I);
			if(timeForUpdatingPhysics)
				DemoEngine.UpdatePhysics(I);
			updateStatistics();
			if(timeForRendering(DemoEngine, need_to_redraw))
			{
				DemoEngine.Render();
				need_to_redraw = false;
			}
			FPSControl();
			
			SDL_Delay(1);
		}

	}

	private static boolean getInput() {
		// TODO Auto-generated method stub
		
		return false;
	}
	
	private static void timeForRendering(CMZEngine game, boolean need_to_redraw) {
		int act_time = SDL_GetTicks();
		int frames = 0;
		while(act_time - time >= REDRAWING_PERIOD && frames<MAX_FRAME_SKIP) {
			time += REDRAWING_PERIOD;
			keyboard->cycle();
			if (!game->cycle(k)) quit = true;
			act_time = SDL_GetTicks();
			need_to_redraw = true;
			frames++;
		}
		if (time < act_time) time = act_time;
		
		return need_to_redraw;
	}

	private static void updateStatistics() {
		// TODO Auto-generated method stub
		
	}

	private static void FPSControl() {
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
