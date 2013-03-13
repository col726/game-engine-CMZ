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
	    //addUser(200, 400, ui.getWidth(null), ui.getHeight(null), ui);
	    
	    //this.User.addScenetoAnimation(new ImageIcon("res/images/sprite1.png").getImage());
	    //this.User.addScenetoAnimation(new ImageIcon("res/images/sprite2.png").getImage());
	    //this.User.addScenetoAnimation(new ImageIcon("res/images/sprite3.png").getImage());
	    

	    //Image i = new ImageIcon("res/images/sprite0.png").getImage();
	    //createObject(300, 400, 34, 56, i, false);

	    Image ai = new ImageIcon("res/images/sprite02.png").getImage();
	    addAI(100, 400, 25, 25, ai);
	    
	    Image i = new ImageIcon("res/images/sprite0.png").getImage();
	    createObject(300, 400, 34, 56, i, false);
	    
	    Image box = new ImageIcon("res/images/box128.png").getImage();
	    addUser(0, 500, 34, 68, ui);
	    
	    for(int k = 0; k < 12; k++)
	    {
	    	createObject((k*64), 600, 64, 64, box, false);
	    }
	    
	    createObject(640, 550, 32, 32, box, true);
	    
	    
	    //Image i2 = new ImageIcon("res/images/floor.png").getImage();
		//createObject(0, 600, 400, 50, i2, false)
	}

}
