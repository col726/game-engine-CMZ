package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import main.PathFindingInterfaces.Mover;
import main.PathFindingInterfaces.TileBasedMap;
import main.gameObject.GameObject;

public class GameLevel implements TileBasedMap {
	
	private int TileWidth;
	private int TileHeight;
	private int[][] units;
	private boolean[][] visited;
	private List<GameObject> LevelUnits;
	private Goal LevelGoal;
	private World jBoxWorld;
	private Vec2 gravity;
	private boolean doSleep = true;

	protected float timeStep;
	protected int velocityIterations;
	protected int positionIterations;
	
	protected GameObject User;
	
	public GameLevel(int height, int width) {
		LevelUnits = new ArrayList<GameObject>();
		gravity = new Vec2(0.0f, 10.0f);
		jBoxWorld = new World(gravity, doSleep);
		
		TileHeight = height;
		TileWidth = width;
		
		units = new int[TileWidth][TileHeight];
		visited = new boolean[TileWidth][TileHeight];
	}

	public void setGoal(Goal goal) {
		LevelGoal = goal;
	}

	public Goal getGoal() {
		return LevelGoal;
	}
	
	@Override
	public int getWidthInTiles() {
		return TileWidth;
	}

	@Override
	public int getHeightInTiles() {
		return TileHeight;
	}

	@Override
	public void pathFinderVisited(int x, int y) {
		visited[x][y] = true;
	}

	@Override
	public boolean blocked(Mover mover, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getCost(Mover mover, int sx, int sy, int tx, int ty) {
		return 1;
	}
	
	public boolean visited(int x, int y) {
		return visited[x][y];
	}
	
	public void createObject(int x, int y, int w, int h, Image i, boolean isMovable)
	{
		GameObject go = new GameObject(new Vec2(x,y), w, h, i, isMovable);
		
		go.setGameBody(this.jBoxWorld.createBody(go.getBodyDef()));
		
		LevelUnits.add(go);
	}
	
	public void createObject(int x, int y, int w, int h, Image i, boolean isMovable, File soundFile)
	{
		GameObject go = new GameObject(new Vec2(x,y), w, h, i, isMovable, soundFile);
		
		go.setGameBody(this.jBoxWorld.createBody(go.getBodyDef()));
		
		LevelUnits.add(go);
	}
	
	public void addUser(int x, int y, int w, int h, Image i) {
		User = new GameObject(new Vec2(x, y), w, h, i, true);
		
		User.setGameBody(this.jBoxWorld.createBody(User.getBodyDef()));
	}
	
	public void updatePhysics(String gameAction) {
		updateUserPhysics(gameAction);
		updateLevelPhysics();
	}

	private void updateUserPhysics(String gameAction) {
		Body body = User.getGameBody();
		if(gameAction == "Right")
		{
			body.setTransform(new Vec2((body.getPosition().x + 2), (body.getPosition().y)), 0.0f);
		}
		if(gameAction == "Left")
		{
			body.setTransform(new Vec2((body.getPosition().x - 2), (body.getPosition().y)), 0.0f);
		}
		if(gameAction == "Up")
		{
			body.setTransform(new Vec2((body.getPosition().x), (body.getPosition().y - 2)), 0.0f);
		}
		if(gameAction == "Down")
		{
			body.setTransform(new Vec2((body.getPosition().x), (body.getPosition().y + 2)), 0.0f);
		}
	}
	
	private void updateLevelPhysics() {
		this.jBoxWorld.step(timeStep, velocityIterations, positionIterations);
		
		for(int i = 0; i < LevelUnits.size(); i++)
		{
			LevelUnits.get(i).updatePosition();
		}
	}
	
	public void renderLevel(Graphics2D g) {
		LevelGoal.showGoal(g);
		renderLevelUnits(g);
		renderUser(g);
	}
	
	private void renderUser(Graphics2D g) {
		Body body = User.getGameBody();
		g.setColor(Color.BLUE);
		g.fillRect((int)body.getPosition().x, (int)body.getPosition().y, User.getWidth(), User.getHeight());
	}
	
	private void renderLevelUnits(Graphics2D g) {
		for(int i = 0; i < LevelUnits.size(); i++)
		{
			GameObject temp = LevelUnits.get(i);
			g.drawImage(temp.getImage(), (int)temp.getPosition().x, (int)temp.getPosition().y, temp.getWidth(), temp.getHeight(), null);
		}
	}

}
