package main;

public class GameVector {

	private int X;
	private int Y;
	
	public GameVector(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}
}
