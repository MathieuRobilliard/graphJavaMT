package labyrinth;

import graph.Vertex;

public class Cell extends Vertex {

	private int coordinateX;
	private int coordinateY;
	private BoxType type;
	
	
	public Cell(String name, int coordinateX, int coordinateY, BoxType type) {
		super(name);
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.type = type;
	}


	public int getCoordinateX() {
		return coordinateX;
	}


	public int getCoordinateY() {
		return coordinateY;
	}


	public BoxType getType() {
		return type;
	}
	
	
	
	
	
}
