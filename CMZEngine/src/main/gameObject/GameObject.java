package main.gameObject;



import org.jbox2d.dynamics.BodyDef;

import main.GameVector;
import main.Sound.GameSound;


public class GameObject {
	
	private GameSound defaultSound;
	private GameVector position;
	private BodyDef bodyDef; 
	
	public GameObject()
	{
		
		bodyDef = new BodyDef();
		System.out.println("Created a game Object");
	}

	public GameVector getPosition() {
		return position;
	}

	public void setPosition(GameVector position) {
		this.position = position;
	}
	
	public void setPosition(int x, int y) {
		this.position.setX(x);
		this.position.setY(y);
	}

	
}
