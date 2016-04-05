
import graph.Edge;
import graph.Graph;
import graph.UndirectedEdge;
import graph.Vertex;
import graph.DirectedEdge;

public class TestGraph {

	/**
	 * The main method, to create a graph.
	 * Create a Matrix for a directed graph and a Matrix for an undirected graph. 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");
		
		// Create few undirected Edges
		Edge unEdge1 = new UndirectedEdge(vertexA, vertexB);
		Edge unEdge2 = new UndirectedEdge(vertexB, vertexC);
		Edge unEdge3 = new UndirectedEdge(vertexC, vertexC);
		
		// Create few directed Edges
		Edge diEdge1 = new DirectedEdge(vertexA, vertexC);
		Edge diEdge2 = new DirectedEdge(vertexC, vertexD);
		Edge diEdge3 = new DirectedEdge(vertexD, vertexA);
		
		// Create a matrix about an undirected graph
		System.out.println("----- Undirected Matrix -----");
		
		AdjacencyMatrixGraph undMatrix1 = new AdjacencyMatrixGraph(6,6,false);
		
		undMatrix1.setVertex(vertexA);
		undMatrix1.setVertex(vertexB);
		undMatrix1.setVertex(vertexC);
		undMatrix1.setVertex(vertexD);
		undMatrix1.setVertex(vertexE);
		undMatrix1.setVertex(vertexE);	// test about existing Vertex -- OK
		undMatrix1.setVertex(vertexA);	// test to out of range the array of vertices -- OK
		
		undMatrix1.setEdge(unEdge1); 
		undMatrix1.setEdge(unEdge2);
		undMatrix1.setEdge(unEdge3);
		undMatrix1.setEdge(unEdge3);	// test about existing Edge -- OK
		
		// Create a matrix about an directed graph
		System.out.println("----- Directed Matrix -----");

		AdjacencyMatrixGraph dirMatrix1 = new AdjacencyMatrixGraph(10,10,true);
				
		dirMatrix1.setVertex(vertexA);
		dirMatrix1.setVertex(vertexB);
		dirMatrix1.setVertex(vertexC);
		dirMatrix1.setVertex(vertexD);
		dirMatrix1.setVertex(vertexE);
		dirMatrix1.setVertex(vertexE);	// test about existing Vertex -- OK
		
		dirMatrix1.setEdge(diEdge1); 
		dirMatrix1.setEdge(diEdge2);
		dirMatrix1.setEdge(diEdge3);
		dirMatrix1.setEdge(diEdge3);	// test about existing Edge -- OK
		dirMatrix1.setEdge(unEdge1);	// test about undirected Edge in directed graph -- OK
		
		// Create a matrix impossible to create
		System.out.println("----- Bad Matrix -----");
		AdjacencyMatrixGraph undMatrix2 = new AdjacencyMatrixGraph(0,1,false);	// OK
		
		System.out.println("----- End of the test -----");
	}
}
