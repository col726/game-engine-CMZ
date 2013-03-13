package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Goal {
	public GameVector goalPoint;
	
	public Goal(int x, int y)
	{
		goalPoint = new GameVector(x, y);
	}
	
	public void showGoal(Graphics2D g)
	{
		draw(g);
	}
	
	private synchronized void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(goalPoint.getX() - 50, goalPoint.getY() - 50, 100, 100);
		g.setColor(Color.BLACK);
		g.fillOval(goalPoint.getX() - 40, goalPoint.getY() - 40, 80, 80);
		g.setColor(Color.RED);
		g.fillOval(goalPoint.getX() - 25, goalPoint.getY() - 25, 50, 50);
		g.setColor(Color.BLACK);
		g.fillOval(goalPoint.getX() - 15, goalPoint.getY() - 15, 30, 30);
		g.setColor(Color.RED);
		g.fillOval(goalPoint.getX() - 5, goalPoint.getY() - 5, 10, 10);
	}
}
