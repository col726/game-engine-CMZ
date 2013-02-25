package main;

import java.awt.*;
import java.awt.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import javax.media.opengl.*;

public class DemoGame {

	
	private static int time = 0;
	private static final int REDRAWING_PERIOD = 20;
	private static final int MAX_FRAME_SKIP = 10;
	private static boolean quit2 = false;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CMZEngine DemoEngine = new CMZEngine();
		
		boolean timeForUpdatingAI = true;
		boolean timeForUpdatingPhysics = true;
		boolean timeForRendering = true;
		
		boolean quit = false;
		
		
		Object I;
		
		DemoEngine.Init();
		
		while(!quit)
		{
			quit = pollForOSMessages();
			I = getInput();
			
			DemoEngine.UpdateAI(I);
			DemoEngine.addToTextBox("--AI Updated");
			
			DemoEngine.UpdatePhysics(I);
			DemoEngine.addToTextBox("--Physics Updated");
			updateStatistics();

			FPSControl(DemoEngine);
			DemoEngine.addToTextBox("--Frames Update");
			
			SDL_Delay(1);
		}

	}

	private static void SDL_Delay(int i) {
		// TODO Auto-generated method stub
		
	}

	private static int SDL_GetTicks() {
		// TODO Auto-generated method stub
		return 60;
	}

	private static boolean getInput() {
		// TODO Auto-generated method stub
		
		return false;
	}
	
	private static void FPSControl(CMZEngine game) {
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
			game.Render();
			need_to_redraw = false;
		}
	}

	private static void updateStatistics() {
		// TODO Auto-generated method stub
		
	}

	//Note: pollForOSMessages returns true if the game loop should exit
	private static boolean pollForOSMessages() {
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
