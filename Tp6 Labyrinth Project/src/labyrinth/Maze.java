package labyrinth;
import graph.ImplGraph;

public class Maze extends ImplGraph{
	
	private int width;
	private int height;

	public Maze(int width, int height) {
		super(((width-2)*(height-2)*4) + (width-2)*3*2 + (height-2)*3*2 + 4*2, width*height, false);
		
		
	}
	
	

}
