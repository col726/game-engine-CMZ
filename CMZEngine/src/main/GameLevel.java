package main;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import main.ArtificialIntelligence.AIModule;
import main.PathFindingInterfaces.Mover;
import main.PathFindingInterfaces.TileBasedMap;
import main.Sound.GameSound;
import main.gameObject.GameObject;

public class GameLevel implements TileBasedMap {
	protected ScreenManager s;
	
	private int TileWidth;
	private int TileHeight;
	private int PixelToTileWidth;
	private int PixelToTileHeight;
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
	protected int AIUnitID;
	protected AIModule AIUnit;
	
	protected GameSound LevelMusic;
	protected Image LevelBackground;
	
	public GameLevel(int height, int width) {
		s = new ScreenManager();
		DisplayMode dm = s.getCurrentDisplayMode();
		
		LevelUnits = new ArrayList<GameObject>();
		gravity = new Vec2(0.0f, 10.0f);
		jBoxWorld = new World(gravity, doSleep);
		
		TileHeight = dm.getHeight(); //height;
		TileWidth = dm.getWidth(); //width;
		
		PixelToTileHeight = (int)dm.getHeight() / TileHeight;
		PixelToTileWidth = (int)dm.getWidth() / TileWidth;
		
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
	
	public void setUnit(int x, int y, int unitID) {
		int tileX = (int)(x / PixelToTileWidth);
		int tileY = (int)(y / PixelToTileHeight);
		units[tileX][tileY] = unitID;
		
		System.out.println("Unit " + unitID + " : " + x + " => " + tileX + "; " + y + " => " + tileY);
	}
	
	public void setUnit(int x, int y, int w, int h, int unit) {
		units[x][y] = unit;
	}
	
	public GameObject getUnit(int unitID) {
		return LevelUnits.get(unitID);
	}
	
	public void createObject(int x, int y, int w, int h, Image i, boolean isMovable)
	{
		GameObject go = new GameObject(new Vec2(x,y), w, h, i, isMovable);
		
		go.setGameBody(this.jBoxWorld.createBody(go.getBodyDef()));
		
		LevelUnits.add(go);
		int unitID = LevelUnits.lastIndexOf(go);
		setUnit(x, y, unitID);
	}
	
	public void createObject(int x, int y, int w, int h, Image i, boolean isMovable, File soundFile)
	{
		GameObject go = new GameObject(new Vec2(x,y), w, h, i, isMovable, soundFile);
		
		go.setGameBody(this.jBoxWorld.createBody(go.getBodyDef()));
		
		LevelUnits.add(go);
		int unitID = LevelUnits.lastIndexOf(go);
		setUnit(x, y, unitID);
	}
	
	public void addUser(int x, int y, int w, int h, Image i) {
		User = new GameObject(new Vec2(x, y), w, h, i, true);
		
		User.setGameBody(this.jBoxWorld.createBody(User.getBodyDef()));
		int unitID = -1;
		setUnit(x, y, unitID);
	}
	
	public void addAI(int x, int y, int w, int h, Image i) {
		GameObject ai = new GameObject(new Vec2(x, y), w, h, i, false);
		
		ai.setGameBody(this.jBoxWorld.createBody(ai.getBodyDef()));
		LevelUnits.add(ai);
		int unitID = LevelUnits.lastIndexOf(ai);
		setUnit(x, y, unitID);

		AIUnitID = unitID;
		AIUnit = new AIModule(AIUnitID, this);
	}
	
	public void updatePhysics(String gameAction) {
		updateUserPhysics(gameAction);
		Vec2 newLocation = AIUnit.advance(this);
		LevelUnits.get(AIUnitID).getGameBody().setTransform(newLocation, 0.0f);
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
		
		User.updatePosition();
		
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
	
	public void UpdateSound()
	{
		
		if(!LevelMusic.isPlaying)
			LevelMusic.play();
		
		for(int i = 0; i < LevelUnits.size(); i++)
		{
			GameSound curr = LevelUnits.get(i).getDefaultSound();
			
			if(!curr.equals(null))
			{
				if(!curr.isPlaying)
					curr.play();
			}
		}
	}
	
	private void renderUser(Graphics2D g) {
		//Body body = User.getGameBody();
		g.drawImage(User.getImage(), (int)User.getPosition().x, (int)User.getPosition().y, User.getWidth(), User.getHeight(), null);
	}
	
	private void renderLevelUnits(Graphics2D g) {
		for(int i = 0; i < LevelUnits.size(); i++)
		{
			GameObject temp = LevelUnits.get(i);
			g.drawImage(temp.getAnimationImage(), (int)temp.getPosition().x, (int)temp.getPosition().y, temp.getWidth(), temp.getHeight(), null);
		}
	}

	public void Init() {
		// TODO Auto-generated method stub
		
	}

}
