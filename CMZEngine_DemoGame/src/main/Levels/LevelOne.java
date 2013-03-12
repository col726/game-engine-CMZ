package main.Levels;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import main.GameLevel;
import main.Goal;

public class LevelOne extends GameLevel {

	public LevelOne() {
		super(50, 50);

		Goal theGoal = new Goal(400, 500);	
		setGoal(theGoal);
		
		timeStep = 1.0f / 60.0f;
	    velocityIterations = 6;
	    positionIterations = 12;
	    
	    File sound = new File("res/sounds/retro.wav");
	    
	    Image ui = new ImageIcon("res/images/sprite3.png").getImage();
	    addUser(200, 400, 25, 25, ui);
	    
	    Image i = new ImageIcon("res/images/sprite0.png").getImage();
	    createObject(300, 600, 500, 10, i, false, sound);
	    
	    
	    Image i2 = new ImageIcon("res/images/floor.png").getImage();
		createObject(0, 600, 800, 50, i2, false, sound);
	    
	}

}
