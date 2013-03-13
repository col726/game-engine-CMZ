package main.ArtificialIntelligence;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jbox2d.common.Vec2;

import main.GameLevel;
import main.PathFindingInterfaces.*;
import main.gameObject.GameObject;

public class AIModule {
	private GameLevel Level;
	private int UnitID;
	private PathFinder Finder;
	private Path Path;
	
	public AIModule(int aiUnitID, GameLevel level) {
		Level = level;
		UnitID = aiUnitID;
		Finder = new AStarPathFinder(Level, 500, true);
		int aiStartX = (int)(Level.getUnit(aiUnitID)).getPosition().x;
		int aiStartY = (int)(Level.getUnit(aiUnitID)).getPosition().y;
		
		Path = Finder.findPath(new UnitMover(aiUnitID), aiStartX, aiStartY, Level.getGoal().goalPoint.getX(), Level.getGoal().goalPoint.getY());
		//System.out.println(Path.toString());
	}
	
	public Vec2 advance(GameLevel level) {
		int x = (int)(level.getUnit(UnitID)).getPosition().x;
		int y = (int)(level.getUnit(UnitID)).getPosition().y;
		
		if (Path != null)
		{
			x = Path.getStep(1).getX();
			y = Path.getStep(1).getY();
			
			level.getUnit(UnitID).getGameBody().setTransform(new Vec2(x, y), 0.0f);
			
			int aiStartX = (int)(level.getUnit(UnitID)).getPosition().x;
			int aiStartY = (int)(level.getUnit(UnitID)).getPosition().y;
			
			System.out.println(x + ", " + y + " => " + aiStartX + ", " + aiStartY);
			
			Path = Finder.findPath(new UnitMover(UnitID), aiStartX, aiStartY, level.getGoal().goalPoint.getX(), level.getGoal().goalPoint.getY());
		}
		
		return new Vec2(x, y);
		
		
		
		//for (int x=0;x<level.getWidthInTiles();x++) {
		//	for (int y=0;y<level.getHeightInTiles();y++) {
		//		if (Path != null) {
		//			if (Path.contains(x, y)) {
		//				g.setColor(Color.blue);
		//				g.fillRect((x*16)+4, (y*16)+4,7,7);
		//			}
		//		}
		//	}
		//}
	}
}