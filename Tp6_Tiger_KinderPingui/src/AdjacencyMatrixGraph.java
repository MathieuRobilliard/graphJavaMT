import exception.MinimumSizeOfGraphNotRespected;
import graph.Edge;
import graph.Graph;
import graph.Vertex;

public abstract class AdjacencyMatrixGraph implements Graph {

	protected Edge[] edges;
	protected int edgesCounter;
	
	protected Vertex[] vertices;
	protected int verticesCounter;
	
	protected boolean[][] adjacencyMatrix; // array of array 
	
	
	/**
	 * The constructor of the adjacency matrix.
	 * @param maxEdges The maximum number of Edges in the graph, must be >= 1.
	 * @param maxVertices The maximum number of Vertices in the graph, must be >= 2.
	 */
	public AdjacencyMatrixGraph(int maxEdges, int maxVertices) throws MinimumSizeOfGraphNotRespected {
		
		if (maxEdges < 1 || maxVertices < 2) {
			throw new MinimumSizeOfGraphNotRespected(maxEdges, maxVertices);
		} else {
			this.edges = new Edge[maxEdges];
			this.edgesCounter = 0;
			this.vertices = new Vertex[maxVertices];
			this.verticesCounter = 0;
			this.adjacencyMatrix = new boolean[maxVertices][maxVertices];
			
			for (int i = 0; i < maxVertices; i++) {
				for (int j = 0; i < maxVertices; j++) {
					this.adjacencyMatrix[i][j] = false;
				}
			}
		}
	}

}
