
import graph.Edge;
import graph.Graph;
import graph.UndirectedEdge;
import graph.Vertex;
import graph.DirectedEdge;

public class AdjacencyMatrixGraph implements Graph {

	protected Edge[] edges;	// array which contains the edges of the graph.
	protected int edgesCounter;	// To know how many edges there are in the graph
	
	protected Vertex[] vertices; // array which contains the vertices of the graph.
	protected int verticesCounter; // To know how many vertices there are in the graph
	
	protected boolean[][] adjacencyMatrix; // array of array 
	private boolean typeGraph;
	
	
	/**
	 * The constructor of the adjacency matrix.
	 * @param maxEdges The maximum number of Edges in the graph, must be >= 1.
	 * @param maxVertices The maximum number of Vertices in the graph, must be >= 2.
	 * @param typeGraph True if the graph is Directed, False if it is Undirected
	 */
	public AdjacencyMatrixGraph(int maxEdges, int maxVertices, boolean typeGraph) {
		// throws MinimumSizeOfGraphNotRespected
		if (maxEdges < 1 || maxVertices < 2) {
			//throw new MinimumSizeOfGraphNotRespected(maxEdges, maxVertices);
			System.out.println("Il est necessaire d'avoir au moins 1 arête et 2 sommets, alors que vous n'avez autorisez que "
			+ maxEdges + " arêtes et " + maxVertices + " sommets.");
		} else {
			this.edges = new Edge[maxEdges];
			this.edgesCounter = 0;
			this.vertices = new Vertex[maxVertices];
			this.verticesCounter = 0;
			this.adjacencyMatrix = new boolean[maxVertices][maxVertices];
			this.typeGraph  = typeGraph;
			
			for (int i = 0; i < maxVertices; i++) {
				for (int j = 0; j < maxVertices; j++) {
					this.adjacencyMatrix[i][j] = false;	// All values = 0 at the beginning
				}
			}
		}
		
		
	}
	
	@Override
	public Edge[] getEdges() {
		return this.edges;
	}

	@Override
	public Vertex[] getVertexs() {
		return this.vertices;
	}

	@Override
	public void setEdge(Edge edge) {
		// throws NotUndirectedEdge, MaximumSizeReachedOnEdges
		
		if (this.edgesCounter >= this.edges.length) {
			//throw new MaximumSizeReachedOnEdges();
			System.out.println("Vous avez atteint le nombre maximum d'arêtes sur ce graphe.");
			return;
		}
		if (vertexExist(edge.getVertexV1()) == false 
				|| vertexExist(edge.getVertexV2()) == false) {	// If vertex1 or vertex2 don't exist.
			//throw new MissingVertexInGraph();
			System.out.println("One or more of the edge's vertices is not in the graph.");
			return;
		}
		if (edgeExist(edge) == true) {
			System.out.println("The edge is not in the graph.");
			return;
		}
		
		
		if (typeGraph == true) {	// If the graph is directed
			if (edge.getClass() == UndirectedEdge.class) {
				//throw new NotUndirectedEdge();
				System.out.println("Vous essayez d'ajouter une arête qui est dirigée à un graphe qui ne l'est pas.");
			} else {
				this.edges[this.edgesCounter] = edge;	// Insert the Edge in the array of Edges
				this.edgesCounter++;
				int vertex1Index = vertexPosition(edge.getVertexV1());
				int vertex2Index = vertexPosition(edge.getVertexV2());
				this.adjacencyMatrix[vertex2Index][vertex1Index] = true;
			}
		} else if (typeGraph == false) {	// If the graph is undirected
			if (edge.getClass() == DirectedEdge.class) {
				System.out.println("Vous essayez d'ajouter une arête qui n'est pas dirigée à un graphe qui l'est.");
			} else {
				this.edges[this.edgesCounter] = edge;	// Insert the Edge in the array of Edges
				this.edgesCounter++;
				int vertex1Index = vertexPosition(edge.getVertexV1());
				int vertex2Index = vertexPosition(edge.getVertexV2());
				this.adjacencyMatrix[vertex1Index][vertex2Index] = true;
				this.adjacencyMatrix[vertex2Index][vertex1Index] = true;
			}
		}
	}

	@Override
	public void setVertex(Vertex vertex) {
		//throws MaximumSizeReachedOnVertices {
	
		if (this.verticesCounter >= this.vertices.length) {
			//throw new MaximumSizeReachedOnVertices();
			System.out.println("Vous avez atteint le nombre maximum de sommets sur ce graphe.");
			return;
		} else if (vertexExist(vertex) == true) {
			System.out.println("The vertex is not in the graph.");
			return;
		} else {
			this.vertices[this.verticesCounter] = vertex;	
			this.verticesCounter++;
		}
		
	}
	
	/**
	 * Check if the vertex is in the array of vertices of the graph.
	 * @param vertex The vertex to check.
	 * @return True if the vertex is in the graph, False else.
	 */
	private boolean vertexExist(Vertex vertex) {
		for (int i = 0; i < this.verticesCounter; i++) {
			if (this.vertices[i] == vertex) {
				return true;
			} 
		} 
		return false;
	}
	
	/**
	 * To know the index of a vertex in the array of vertex named vertices
	 * @param vertex The vertex to get the index.
	 * @return Return the index of the vertex in vertices or return -1 if the vertex not exists.
	 */
	private int vertexPosition(Vertex vertex) {
		for (int i = 0; i < this.verticesCounter; i++) {
			if (this.vertices[i] == vertex) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Check if the edge is in the array of edges of the graph.
	 * @param edge The edge to check.
	 * @return True if the edge is in the graph, False else.
	 */
	private boolean edgeExist(Edge edge) {
		for (int i = 0; i < this.edgesCounter; i++) {
			if (this.edges[i] == edge) {
				return true;
			} 
		} 
		return false;
	}

}
