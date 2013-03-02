package main.gameObject;



import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

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
	private FixtureDef fixture;
	private Image i;
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
		
		fixture = new FixtureDef();
		fixture.shape = bb;
	    fixture.density = 1.0f;
	    fixture.friction = 0.3f;
		
	    
	    
	    a = new animation();
		i = new ImageIcon(img).getImage();
		a.addScene(i, 250);
	}
	
	public GameObject(Vec2 p, int w, int h, Image i, boolean canMove, File soundFile)
	{
		this.position = p;
		
		this.width = (float)w;
		this.height = (float)h;
		
		bodyDef = new BodyDef();
		if (canMove)
			bodyDef.type = BodyType.DYNAMIC;
		bodyDef.position.set(p);
		
		bb = new PolygonShape();
		bb.setAsBox(width, height);
		
		fixture = new FixtureDef();
		fixture.shape = bb;
	    fixture.density = 1.0f;
	    fixture.friction = 0.3f;
		
		a = new animation();
		this.i = i;
		a.addScene(i, 250);
		
		try {
			defaultSound = new GameSound(soundFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		gameBody.createFixture(fixture);
	}
	
	public BodyDef getBodyDef() {
		return this.bodyDef;
	}
	
	public Image getImage() {
		return this.i;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return (int)this.width;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return (int)this.height;
	}
	
	public void updatePosition()
	{
		this.position = this.gameBody.getPosition();
	}

	public GameSound getDefaultSound() {
		return defaultSound;
	}

	public void setDefaultSound(GameSound defaultSound) {
		this.defaultSound = defaultSound;
	}

	
}
