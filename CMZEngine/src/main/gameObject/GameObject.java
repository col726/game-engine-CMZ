package main.gameObject;



import java.awt.Image;

import javax.swing.ImageIcon;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;

import main.GameVector;
import main.Graphics.animation;
import main.Sound.GameSound;


public class GameObject {
	
	private GameSound defaultSound;
	private Vec2 position;
	float width;
	float height;
	private BodyDef bodyDef; 
	private Body gameBody;
	private animation a;
	private PolygonShape bb;
	
	public GameObject(int x, int y)
	{	
		position.set(x, y);
		System.out.println("Created a game Object");
	}
	
	public GameObject(Vec2 p, int w, int h, String img, boolean canMove)
	{
		this.position = p;
		
		this.width = (float)w;
		this.height = (float)h;
		
		bodyDef = new BodyDef();
		bodyDef.position.set(p);
		if (canMove)
			bodyDef.type = BodyType.DYNAMIC;
		
		bb = new PolygonShape();
		bb.setAsBox(width, height);
		
		
		Image i = new ImageIcon(img).getImage();
		a.addScene(i, 250);
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
		gameBody.createFixture(bb, 0.0f);
	}
	
	public BodyDef getBodyDef() {
		return this.bodyDef;
	}

	
}
