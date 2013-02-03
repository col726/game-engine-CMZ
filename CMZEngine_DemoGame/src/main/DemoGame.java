package main;

import java.awt.event.*;

public class DemoGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CMZEngine DemoEngine = new CMZEngine();
		
		boolean timeForUpdatingAI = true;
		boolean  timeForUpdatingPhysics = true;
		boolean timeForRendering = true;
		boolean quit = false;
		
		DemoEngine.Init();
		
		while(!quit)
		{
			pollForOSMessages();
			quit = getInput();
			if(timeForUpdatingAI)
				DemoEngine.UpdateAI();
			if(timeForUpdatingPhysics)
				DemoEngine.UpdatePhysics();
			updateStatistics();
			if(timeForRendering)
				DemoEngine.Render();
			FPSControl();
		}

	}

	private static boolean getInput() {
		// TODO Auto-generated method stub
		
		return false;
	}

	private static void updateStatistics() {
		// TODO Auto-generated method stub
		
	}

	private static void FPSControl() {
		// TODO Auto-generated method stub
		
	}

	private static void pollForOSMessages() {
		// TODO Auto-generated method stub
		
	}

}
