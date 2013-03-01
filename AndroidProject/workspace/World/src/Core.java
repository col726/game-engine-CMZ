import java.awt.*;

import javax.swing.*;

public abstract class Core {
	
	private static final DisplayMode modes[] = {
		new DisplayMode(800,600,32,0),
		new DisplayMode(800,600,24,0),
		new DisplayMode(800,600,16,0),
		new DisplayMode(640,480,32,0),
		new DisplayMode(640,480,24,0),
		new DisplayMode(640,480,16,0),
	};
	
	private boolean running;
	protected ScreenManager s;
	
	public void stop(){
		running = false;
	}
	
	public void run(){
		try{
			init();
			gameLoop();
		}finally{
			s.restoreScreen();
		}
	}
//set to full screen
	public void init(){
		s = new ScreenManager();
		DisplayMode dm = s.findFirstCompatibleMode(modes);
		s.setFullScreen(dm);
		Window w = s.getFullScreenWindow();
		w.setFont(new Font("Arial", Font.PLAIN, 20));
		w.setBackground(Color.BLUE);
		w.setForeground(Color.WHITE);
		running = true;
	}
//main grameloop
	public void gameLoop(){
		long startingTime = System.currentTimeMillis();
		long cumTime = startingTime;
		
		while (running){
			long timePassed = System.currentTimeMillis() - cumTime;
			cumTime += timePassed;
//			a.update(timePassed);
			update(timePassed);
	//draw graphics
			Graphics2D g = s.getGraphics();
			draw(g);
			g.dispose();
			s.update();
				
			try {
				Thread.sleep(20);
			}catch(Exception ex){}
		}
	}
//update animation
	public void update(long timePassed){
	
	}
//draw to screen
	public void draw(Graphics2D g){
		
	}
}