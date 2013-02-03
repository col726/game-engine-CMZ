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
		
	}


	public void UpdatePhysics() {
		// TODO Auto-generated method stub
		
	}

	
	public void UpdateAI() {
		// TODO Auto-generated method stub
		
	}


	public void Init() {
		// TODO Auto-generated method stub
		world = new GameObject();
	}

}
