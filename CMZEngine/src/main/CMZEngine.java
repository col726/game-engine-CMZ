package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;

import main.Graphics.Camera;
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
		gravity = new Vec2(0.0f, -10.0f);
		jBoxWorld = new World(gravity, doSleep);
		
		System.out.println("You Created a CMZ Engine!");
		engine_log += "\nYou Created a CMZ Engine!";
	}


	//Only render objects within camera viewpoint
	public void Render(Graphics2D g) {
		
		g.setColor(Color.BLUE);
		//g.drawString("Engine Messages\n" + engine_log, 300, 50);
		g.drawRect((int)body.getPosition().x, (int)body.getPosition().y, 50, 50);
		
		g.setColor(Color.CYAN);
		g.fillRect((int)groundBody.getPosition().x, (int)groundBody.getPosition().y, 75, 75);
		// TODO Auto-generated method stub
		//System.out.println("Rendering..." + gameObjects.toString());
		//engine_log += "\nRendering..." + gameObjects.toString();
	}


	public void UpdatePhysics(String gameAction) {
		// TODO Auto-generated method stub
		System.out.println("Updating Physics..." + gameAction);
		engine_log += "\nUpdating Physics..." + gameAction;
		
		body.setTransform(new Vec2((body.getPosition().x + 1), (body.getPosition().y + 1)), 0.0f);
		
		if(gameAction == "Right")
		{
			groundBody.setTransform(new Vec2((groundBody.getPosition().x + 1), (groundBody.getPosition().y)), 0.0f);
		}
		if(gameAction == "Left")
		{
			groundBody.setTransform(new Vec2((groundBody.getPosition().x - 1), (groundBody.getPosition().y)), 0.0f);
		}
		if(gameAction == "Up")
		{
			groundBody.setTransform(new Vec2((groundBody.getPosition().x), (groundBody.getPosition().y - 1)), 0.0f);
		}
		if(gameAction == "Down")
		{
			groundBody.setTransform(new Vec2((groundBody.getPosition().x), (groundBody.getPosition().y + 1)), 0.0f);
		}
		
		//jBox trial
		this.jBoxWorld.step(timeStep, velocityIterations, positionIterations);
		
		Vec2 testVec = body.getPosition();
		float angle = body.getAngle();
		System.out.println("Box X Position: " + testVec.x + " Box Y Position: " + testVec.y + " BoxAngle: " + angle);
		engine_log += "\nBox X Position: " + testVec.x + " Box Y Position: " + testVec.y + " BoxAngle: " + angle;
		
		/*try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
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
	    
	    BodyDef groundBodyDef = new BodyDef();
	    groundBodyDef.position.set(0.0f, -10.0f);
	    groundBody = this.jBoxWorld.createBody(groundBodyDef);
	    
	    PolygonShape groundBox = new PolygonShape();
	    groundBox.setAsBox(50.0f, 10.0f);
	    
	    groundBody.createFixture(groundBox, 0.0f);
	    
	    dynamicBodyDef = new BodyDef();
	    dynamicBodyDef.type = BodyType.DYNAMIC;
	    dynamicBodyDef.position.set(0.0f, 4.0f);
	    
	    body = this.jBoxWorld.createBody(dynamicBodyDef);
	    
	    PolygonShape dynamicShape = new PolygonShape();
	    dynamicShape.setAsBox(1.0f, 1.0f);
	    
	    FixtureDef dynamicFixtureDef = new FixtureDef();
	    dynamicFixtureDef.shape = dynamicShape;
	    dynamicFixtureDef.density = 1.0f;
	    dynamicFixtureDef.friction = 0.3f;
	    
	    body.createFixture(dynamicFixtureDef);
	    
	    
	    //int frameWidth = 500;
	    //int frameHeight = 500;
	    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    //GameFrame.setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
	    //GameFrame.setVisible(true);
	}
	
	public void createObject(int x, int y, boolean isMovable)
	{
		GameObject go = new GameObject(x,y);
		if (isMovable)
			go.setGameBody(this.jBoxWorld.createBody(dynamicBodyDef));
		else
			go.setGameBody(this.jBoxWorld.createBody(staticBodyDef));
		gameObjects.add(go);
	}


	public String getUnreadMessages() {
		String messages = engine_log;
		engine_log = "";
		return messages;
	}


}
