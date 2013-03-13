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
	}


	public void UpdatePhysics(String gameAction) {
		Levels.get(CurrentLevel).updatePhysics(gameAction);
		// TODO Auto-generated method stub
		System.out.println("Updating Physics..." + gameAction);
		engine_log += "\nUpdating Physics..." + gameAction;
		
	}
	


	
	public void UpdateAI(String gameAction) {
		// TODO Auto-generated method stub
		System.out.println("Updating AI..." + gameAction);
		engine_log += "\nUpdating AI..." + gameAction;
		
	}
	
	
	public void addToTextBox(String text) {
		TextBox.setText(TextBox.getText() + "<br>" + text);
	}


	public void Init() {
		
	}
	
	
	public void addLevel(GameLevel level) {
		try
		{
			Levels.add(level);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		level.Init();
	}

	public void createObject(int x, int y, int w, int h, Image i, boolean isMovable)
	{
		GameObject go = new GameObject(new Vec2(x,y), w, h, i, isMovable);
		go.setGameBody(this.jBoxWorld.createBody(go.getBodyDef()));
		
		gameObjects.add(go);
	}
	
	public void createObject(int x, int y, int w, int h, Image i, boolean isMovable, File soundFile)
	{
		GameObject go = new GameObject(new Vec2(x,y), w, h, i, isMovable, soundFile);
		
		go.setGameBody(this.jBoxWorld.createBody(go.getBodyDef()));
		
		gameObjects.add(go);
	}
	
	/*public void addGoal(Goal gameGoal)
	{
		GameGoal = gameGoal;
	}*/


	public String getUnreadMessages() {
		String messages = engine_log;
		engine_log = "";
		return messages;
	}


	public void UpdateSound() {
		Levels.get(CurrentLevel).UpdateSound();
		
	}


}
