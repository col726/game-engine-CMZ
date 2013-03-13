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
import main.Graphics.Sprite;
import main.Graphics.animation;
import main.Sound.GameSound;


public class GameObject {
	
	//Sound 
	private GameSound defaultSound;
	
	//Position
	private Vec2 position;
	float width;
	float height;
	float drawWidth;
	float drawHeight;
	
	//jBox2D
	private BodyDef bodyDef; 
	private Body gameBody;
	private FixtureDef fixture;
	private PolygonShape bb;
	
	//Animation
	private Image i;
	private animation a;
	
	private Sprite sprite;
	
	
	public GameObject(int x, int y)
	{	
		position.set(x, y);
		System.out.println("Created a game Object");
	}
	
	public GameObject(Vec2 p, int w, int h, Image i, boolean canMove)
	{
		this.position = p;
		this.drawWidth = (float)w;
		this.drawHeight = (float)h;
		
		Vec2 jBoxVec = pixelToJBox(p);
		Vec2 jBoxW_H = pixelToJBox(new Vec2(p.x + w, p.y + h));
		
		this.width = (float)(jBoxW_H.x - jBoxVec.x);
		this.height = (float)(jBoxW_H.y - jBoxVec.y);
		
		bodyDef = new BodyDef();
		
		
		bodyDef.position.set(jBoxVec.x, jBoxVec.y);
		
		if (canMove)
			bodyDef.type = BodyType.DYNAMIC;
		
		bb = new PolygonShape();
		bb.setAsBox(this.width/2, this.height/2);
		
		fixture = new FixtureDef();
		fixture.shape = bb;
	    fixture.density = 1.0f;
	    fixture.friction = 0.8f;
		
	    
	    
	    a = new animation();
		this.i = i;
		a.addScene(i, 250);
		
		sprite = new Sprite(a);
		
		//defaultSound = new GameSound();
	}
	
	public GameObject(Vec2 p, int w, int h, Image i, boolean canMove, File soundFile)
	{	
		this(p, w, h, i, canMove);
		
		try {
			defaultSound = new GameSound(soundFile, true, p, w);
			defaultSound.setLoop(0);
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
		return (int)this.drawWidth;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return (int)this.drawHeight;
	}
	
	public void updatePosition()
	{
		this.position = jBoxToPixel(this.gameBody.getPosition());
		this.sprite.update(250);
	}

	public GameSound getDefaultSound() {
		return defaultSound;
	}

	public void setDefaultSound(GameSound defaultSound) {
		this.defaultSound = defaultSound;
	}
	
	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite s) {
		this.sprite = s;
	}

	public void addScenetoAnimation(Image i)
	{
		this.a.addScene(i, 250);
		this.sprite = new Sprite(a);
	}

	public Image getAnimationImage() {
		// TODO Auto-generated method stub
		return this.a.getImage();
	}
	
	
	private Vec2 pixelToJBox(Vec2 v){
		
		float newX, newY, tempX, tempY;
		
		tempX = v.x /768;
		tempY = v.y/1366;
		
		newX = -100 + (tempX * 200);
		newY = -100 + (tempY * 200);
		
		return new Vec2(newX, newY);
	}
	
	
	private Vec2 jBoxToPixel(Vec2 v){
		
		float newX, newY, tempX, tempY;
		
		tempX = (v.x + 100) / 200;
		tempY = (v.y + 100) / 200;
		
		newX = (tempX * 768);
		newY = (tempY * 1366);
		
		return new Vec2(newX, newY);
	}

	public void setGameObjectTransform(Vec2 newLocation, float f) {
		// TODO Auto-generated method stub
		this.gameBody.setTransform(pixelToJBox(newLocation), f);
		updatePosition();
		
	}
}
