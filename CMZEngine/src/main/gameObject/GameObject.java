package main.gameObject;



import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;

import main.GameVector;
import main.Sound.GameSound;


public class GameObject {
	
	private GameSound defaultSound;
	private Vec2 position;
	private BodyDef bodyDef; 
	private Body gameBody;
	
	public GameObject(int x, int y)
	{	
		position.set(x, y);
		System.out.println("Created a game Object");
	}
	
	public GameObject()
	{
		System.out.println("Created a game Object");
	}

	public Vec2 getPosition() {
		return position;
	}

	public void setPosition(Vec2 position) {
		this.position = position;
	}
	
	public void setPosition(int x, int y) {
		this.position.set(x, y);
	}

	public Body getGameBody() {
		return gameBody;
	}

	public void setGameBody(Body gameBody) {
		this.gameBody = gameBody;
	}

	
}
