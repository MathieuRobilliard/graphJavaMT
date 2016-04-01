import exception.MaximumSizeReachedOnEdges;
import exception.MaximumSizeReachedOnVertices;
import exception.MinimumSizeOfGraphNotRespected;
import exception.MissingVertexInGraph;
import exception.NotUndirectedEdge;
import graph.Edge;
import graph.UndirectedEdge;
import graph.Vertex;

public class AdjacencyMatrixUndirectedGraph extends AdjacencyMatrixGraph {

	public AdjacencyMatrixUndirectedGraph(int maxEdges, int maxVertices) throws MinimumSizeOfGraphNotRespected {
		super(maxEdges, maxVertices);
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
	public void setEdge(Edge edge) throws NotUndirectedEdge, MaximumSizeReachedOnEdges {
		if (edge.getClass() != UndirectedEdge.class) {
			throw new NotUndirectedEdge();
		} else if (this.edgesCounter >= this.edges.length) {
			throw new MaximumSizeReachedOnEdges();
		} else if (!vertexExist(edge.getVertexV1()) 
				|| !vertexExist(edge.getVertexV2())) {	// If vertex1 or vertex2 don't exist.
			throw new MissingVertexInGraph();
		} else {
			this.edges[this.edgesCounter] = edge;
			this.edgesCounter++;
			int vertex1Index = vertexPosition(edge.getVertexV1());
			int vertex2Index = vertexPosition(edge.getVertexV2());
			this.adjacencyMatrix[vertex1Index][vertex2Index] = true;
			this.adjacencyMatrix[vertex2Index][vertex1Index] = true;
		}
	}

	@Override
	public void setVertex(Vertex vertex) throws MaximumSizeReachedOnVertices {
	
		if (this.verticesCounter >= this.vertices.length) {
			throw new MaximumSizeReachedOnVertices();
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
	
	
}
