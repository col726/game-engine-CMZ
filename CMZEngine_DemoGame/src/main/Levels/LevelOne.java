package main.Levels;

import java.awt.Image;

import javax.swing.ImageIcon;

import main.GameLevel;
import main.Goal;

public class LevelOne extends GameLevel {

	public LevelOne() {
		super(500, 500);

		Goal theGoal = new Goal(400, 200);	
		setGoal(theGoal);
		
		timeStep = 1.0f / 60.0f;
	    velocityIterations = 6;
	    positionIterations = 12;
	    
	    Image ui = new ImageIcon("res/images/sprite03.png").getImage();
	    addUser(200, 400, 25, 25, ui);
	    
	    Image ai = new ImageIcon("res/images/sprite02.png").getImage();
	    addAI(100, 400, 25, 25, ai);
	    
	    Image i = new ImageIcon("res/images/sprite0.png").getImage();
	    createObject(300, 400, 500, 10, i, false);
	}

}
