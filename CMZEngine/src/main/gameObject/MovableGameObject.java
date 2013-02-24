package main.gameObject;

import org.jbox2d.common.Vec2;

import main.GameVector;

public class MovableGameObject extends GameObject {
	
	public MovableGameObject()
	{
		super();
		
	}
	
	void moveLeft(int dist)
	{
		super.setPosition(new Vec2(super.getPosition().x - dist, super.getPosition().y));
	}
	
	void moveRight(int dist)
	{
		super.setPosition(new Vec2(super.getPosition().x + dist, super.getPosition().y));
	}
	
	void moveUp(int dist)
	{
		super.setPosition(new Vec2(super.getPosition().x, super.getPosition().y + dist));
	}
	
	void moveDown(int dist)
	{
		super.setPosition(new Vec2(super.getPosition().x, super.getPosition().y - dist));
	}
}
