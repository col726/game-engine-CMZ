package main.gameObject;

import main.GameVector;

public class MovableGameObject extends GameObject {
	
	public MovableGameObject()
	{
		super();
		
	}
	
	void moveLeft(int dist)
	{
		super.setPosition(new GameVector(super.getPosition().getX() - dist, super.getPosition().getY()));
	}
	
	void moveRight(int dist)
	{
		super.setPosition(new GameVector(super.getPosition().getX() + dist, super.getPosition().getY()));
	}
	
	void moveUp(int dist)
	{
		super.setPosition(new GameVector(super.getPosition().getX(), super.getPosition().getY() + dist));
	}
	
	void moveDown(int dist)
	{
		super.setPosition(new GameVector(super.getPosition().getX(), super.getPosition().getY() - dist));
	}
}
