package main;

import java.util.ArrayList;
import java.util.List;

import main.Graphics.Camera;

public class CMZEngine {
	
	public Camera gameCamera;
	private List<GameObject> gameObjects;
	
	
	public CMZEngine()
	{
		gameCamera = new Camera();
		gameObjects = new ArrayList<GameObject>();
		System.out.println("You Created a CMZ Engine!");
	}

}
