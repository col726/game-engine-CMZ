package main;

import java.util.ArrayList;
import java.util.List;

import main.Graphics.Camera;

public class CMZEngine {
	
	public Camera gameCamera;
	private List<GameObject> gameObjects;
	private GameObject world;
	
	
	public CMZEngine()
	{
		gameCamera = new Camera();
		gameObjects = new ArrayList<GameObject>();
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


	public void Init() {
		// TODO Auto-generated method stub
		world = new GameObject();
	}

}
