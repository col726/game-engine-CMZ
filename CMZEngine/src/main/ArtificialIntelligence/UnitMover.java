package main.ArtificialIntelligence;

import main.PathFindingInterfaces.Mover;

public class UnitMover implements Mover {
	private int type;
	
	/**
	 * Create a new mover to be used while path finder
	 * 
	 * @param type The ID of the unit moving
	 */
	public UnitMover(int type) {
		this.type = type;
	}
	
	/**
	 * Get the ID of the unit moving
	 * 
	 * @return The ID of the unit moving
	 */
	public int getType() {
		return type;
	}
}
