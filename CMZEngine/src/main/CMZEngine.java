package main;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;

import main.Graphics.Camera;
import main.gameObject.GameObject;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CMZEngine {
	
	public Camera gameCamera;
	private List<GameObject> gameObjects;
	private GameObject world;
	private JFrame GameFrame = new JFrame();
	private JLabel TextBox = new JLabel();
	
	private World jBoxWorld;
	private Vec2 gravity;
	private boolean doSleep = true;
	
	public CMZEngine()
	{
		gameCamera = new Camera();
		gameObjects = new ArrayList<GameObject>();
		jBoxWorld = new World(gravity, doSleep);
		
		System.out.println("You Created a CMZ Engine!");
	}


	//Only render objects within camera viewpoint
	public void Render() {
		// TODO Auto-generated method stub
		System.out.println("Rendering..." + gameObjects.toString());
	}


	public void UpdatePhysics(Object physicsObject) {
		// TODO Auto-generated method stub
		System.out.println("Updating Physics..." + physicsObject.toString());
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void UpdateAI(Object aiObject) {
		// TODO Auto-generated method stub
		System.out.println("Updating AI..." + aiObject.toString());
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void addToTextBox(String text) {
		TextBox.setText(TextBox.getText() + "<br>" + text);
	}


	public void Init() {
		// TODO Auto-generated method stub
		world = new GameObject();
		JFrame.setDefaultLookAndFeelDecorated(true);
		GameFrame.setTitle("My First Swing Application");
		GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JLabel label = new JLabel("Welcome");
	    TextBox.setText("Init Started...");
	    GameFrame.add(TextBox);
	    
	    
	    int frameWidth = 500;
	    int frameHeight = 500;
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    GameFrame.setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
	    GameFrame.setVisible(true);
	}
	
	public void registerObject(GameObject g)
	{
		gameObjects.add(g);
	}


}
