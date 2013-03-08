package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.io.File;

import main.Graphics.Camera;
import main.Sound.GameSound;
import main.gameObject.GameObject;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


public class CMZEngine {
	
	public Camera gameCamera;
	private List<GameObject> gameObjects;
	private List<GameLevel> Levels;
	private int CurrentLevel = 0;
	private GameObject world;
	private JFrame GameFrame = new JFrame();
	private JLabel TextBox = new JLabel();
	
	private World jBoxWorld;
	private Vec2 gravity;
	private boolean doSleep = true;
	private Body groundBody;
	private Body body;
	
	private final float timeStep = 1.0f / 60.0f;
    private final int velocityIterations = 6;
    private final int positionIterations = 12;
    
    private BodyDef dynamicBodyDef;
    private BodyDef staticBodyDef;
    
    private String engine_log = "";
    
    private Goal GameGoal;
    
    private Toolkit toolkit;
    private MediaTracker manager;
    
	public CMZEngine()
	{
		gameCamera = new Camera();
		gameObjects = new ArrayList<GameObject>();
		Levels = new ArrayList<GameLevel>();
		gravity = new Vec2(0.0f, 10.0f);
		jBoxWorld = new World(gravity, doSleep);
		
		System.out.println("You Created a CMZ Engine!");
		engine_log += "\nYou Created a CMZ Engine!";
	}


	//Only render objects within camera viewpoint
	public void Render(Graphics2D g) {
		Levels.get(CurrentLevel).renderLevel(g);
		
		//Levels.get(CurrentLevel).getGoal().showGoal(g);
		GameGoal.showGoal(g);
		
		for(int i = 0; i < gameObjects.size(); i++)
		{
			GameObject temp = gameObjects.get(i);
			g.drawImage(temp.getAnimationImage(), (int)temp.getPosition().x, (int)temp.getPosition().y, temp.getWidth(), temp.getHeight(), null);
		}
		
		/*g.setColor(Color.BLUE);
		//g.drawString("Engine Messages\n" + engine_log, 300, 50);
		g.drawRect((int)body.getPosition().x, (int)body.getPosition().y, 50, 50);
		
		g.setColor(Color.CYAN);
		g.drawLine((int)groundBody.getPosition().x - 40, (int)groundBody.getPosition().y, (int)groundBody.getPosition().x + 800, (int)groundBody.getPosition().y);
	*/
	}


	public void UpdatePhysics(String gameAction) {
		Levels.get(CurrentLevel).updatePhysics(gameAction);
		// TODO Auto-generated method stub
		System.out.println("Updating Physics..." + gameAction);
		engine_log += "\nUpdating Physics..." + gameAction;
		
		GameObject player1 = this.gameObjects.get(0);
		
		//body.setTransform(new Vec2((body.getPosition().x + 1), (body.getPosition().y + 1)), 0.0f);
		
		if(gameAction == "Right")
		{
			player1.getGameBody().setTransform(new Vec2((player1.getGameBody().getPosition().x + 2), (player1.getGameBody().getPosition().y)), 0.0f);
		}
		if(gameAction == "Left")
		{
			player1.getGameBody().setTransform(new Vec2((player1.getGameBody().getPosition().x - 2), (player1.getGameBody().getPosition().y)), 0.0f);
		}
		/*if(gameAction == "Up")
		{
			body.setTransform(new Vec2((body.getPosition().x), (body.getPosition().y - 2)), 0.0f);
		}*/
		/*if(gameAction == "Down")
		{
			body.setTransform(new Vec2((body.getPosition().x), (body.getPosition().y + 2)), 0.0f);
		}*/
		
		//jBox trial
		this.jBoxWorld.step(timeStep, velocityIterations, positionIterations);
		
		Vec2 testVec = player1.getGameBody().getPosition();
		float angle = player1.getGameBody().getAngle();
		System.out.println("Box X Position: " + testVec.x + " Box Y Position: " + testVec.y + " BoxAngle: " + angle);
		engine_log += "\nBox X Position: " + testVec.x + " Box Y Position: " + testVec.y + " BoxAngle: " + angle;
		
		for(int i = 0; i < gameObjects.size(); i++)
		{
			gameObjects.get(i).updatePosition();
		}
		
		/*try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	public void UpdateSound()
	{
		for(int i = 0; i < gameObjects.size(); i++)
		{
			GameSound curr = gameObjects.get(i).getDefaultSound();
			
			if(!curr.equals(null))
			{
				if(!curr.isPlaying)
					curr.play();
			}
		}
	}

	
	public void UpdateAI(String gameAction) {
		// TODO Auto-generated method stub
		System.out.println("Updating AI..." + gameAction);
		engine_log += "\nUpdating AI..." + gameAction;
		//try {
		//	Thread.sleep(1500);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		
	}
	
	
	public void addToTextBox(String text) {
		TextBox.setText(TextBox.getText() + "<br>" + text);
	}


	public void Init() {
		// TODO Auto-generated method stub
		//world = new GameObject();
		//JFrame.setDefaultLookAndFeelDecorated(true);
		//GameFrame.setTitle("My First Swing Application");
		//GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //JLabel label = new JLabel("Welcome");
	    //TextBox.setText("Init Started...");
	    //GameFrame.add(TextBox);
	    
	    /*BodyDef groundBodyDef = new BodyDef();
	    //groundBodyDef.type = BodyType.DYNAMIC;
	    groundBodyDef.position.set(0.0f, 700.0f);
	    groundBody = this.jBoxWorld.createBody(groundBodyDef);
	    
	    PolygonShape groundBox = new PolygonShape();
	    groundBox.setAsBox(400, 20, new Vec2(0.0f, 700f), 0.0f);
	    
	    
	    
	    groundBody.createFixture(groundBox, 0.0f);
	    
	    dynamicBodyDef = new BodyDef();
	    dynamicBodyDef.type = BodyType.DYNAMIC;
	    dynamicBodyDef.position.set(0.0f, 4.0f);
	    
	    body = this.jBoxWorld.createBody(dynamicBodyDef);
	    
	    PolygonShape dynamicShape = new PolygonShape();
	    dynamicShape.setAsBox(50.0f, 50.0f);
	    
	    FixtureDef dynamicFixtureDef = new FixtureDef();
	    dynamicFixtureDef.shape = dynamicShape;
	    dynamicFixtureDef.density = 1.0f;
	    dynamicFixtureDef.friction = 0.3f;
	    
	    body.createFixture(dynamicFixtureDef);
	    
	    */
	    //int frameWidth = 500;
	    //int frameHeight = 500;
	    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    //GameFrame.setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
	    //GameFrame.setVisible(true);
	}
	
<<<<<<< HEAD
	public void createObject(int x, int y, int w, int h, String img, boolean isMovable)
	{		
		GameObject go = new GameObject(new Vec2(x,y), w, h, img, isMovable);
=======
	public void addLevel(GameLevel level) {
		try
		{
			Levels.add(level);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void createObject(int x, int y, int w, int h, Image i, boolean isMovable)
	{
		GameObject go = new GameObject(new Vec2(x,y), w, h, i, isMovable);
>>>>>>> bf740d55eb34e255eeca2dd67a9cd1a0a85502ed
		
		go.setGameBody(this.jBoxWorld.createBody(go.getBodyDef()));
		
		gameObjects.add(go);
	}
	
	public void createObject(int x, int y, int w, int h, Image i, boolean isMovable, File soundFile)
	{
		GameObject go = new GameObject(new Vec2(x,y), w, h, i, isMovable, soundFile);
		
		go.setGameBody(this.jBoxWorld.createBody(go.getBodyDef()));
		
		gameObjects.add(go);
	}
	
	public void addGoal(Goal gameGoal)
	{
		GameGoal = gameGoal;
	}


	public String getUnreadMessages() {
		String messages = engine_log;
		engine_log = "";
		return messages;
	}


}
