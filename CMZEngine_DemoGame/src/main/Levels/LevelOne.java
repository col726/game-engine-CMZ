package main.Levels;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import main.GameLevel;
import main.Goal;
import main.Sound.GameSound;

public class LevelOne extends GameLevel {

	public LevelOne() {
		super(500, 500);


		Goal theGoal = new Goal(400, 200);	
		setGoal(theGoal);
		
		timeStep = 1.0f / 60.0f;
	    velocityIterations = 6;
	    positionIterations = 12;
	    
	    try {
			this.LevelMusic = new GameSound(new File("res/sounds/retro.wav"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    this.LevelBackground = new ImageIcon("res/images/game_background.jpg").getImage();
	    
	    Image ui = new ImageIcon("res/images/sprite0.png").getImage();
	    Image ai = new ImageIcon("res/images/sprite02.png").getImage();
	    Image i = new ImageIcon("res/images/sprite0.png").getImage();
	    Image box = new ImageIcon("res/images/box128.png").getImage();
	    
	    //bottom
	    for(int k = 0; k < 12; k++)
	    {
	    	createObject((k*64), 600, 64, 64, box, false);
	    }

	    for(int k = 13; k < 18; k++)
	    {
	    	createObject((k*64), 600, 64, 64, box, false);
	    }
	    
	    //middle
	    for(int k = 0; k < 3; k++)
	    {
	    	createObject((k*64), 450, 64, 64, box, false);
	    }
	    
	    for(int k = 4; k < 10; k++)
	    {
	    	createObject((k*64), 450, 64, 64, box, false);
	    }
	    
	    //top
	    for(int k = 0; k < 6; k++)
	    {
	    	createObject((k*64), 300, 64, 64, box, false);
	    }
	    
	    for(int k = 7; k < 10; k++)
	    {
	    	createObject((k*64), 300, 64, 64, box, false);
	    }
	    
	    for(int j = 0; j < 12; j++)
	    {
	    	createObject((j*32), 500, 16, 16, box, true);
	    }
	    createObject(640, 550, 32, 32, box, true);
	    
	    //createObject(300, 400, 34, 56, i, false);
	    addUser(0, 500, 34, 68, ui);
	    addAI(100, 575, 25, 25, ai);
	}

}
