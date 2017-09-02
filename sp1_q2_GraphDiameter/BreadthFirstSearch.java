package cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.sp1_q2_GraphDiameter;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.sp1_q2_GraphDiameter.Graph.Edge;
import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.sp1_q2_GraphDiameter.Graph.Vertex;

/**
 * Class that implements Breadth first Search algorithm.
 *
 * @author Ashwin, Arun, Deepak, Haritha
 *
 */
public class BreadthFirstSearch {

	/**
	 * Breadth first algorithm is being used to find the diameter for the given
	 * graph(Tree).
	 *
	 * @param g
	 *            graph
	 * @param v
	 *            current vertex
	 * @return path longest path from the currentVertex
	 */
	static Vertex doBFSAndReturnFarthestNode(CC cc, Graph g, Vertex initVertex) {
		Queue<Vertex> q = new LinkedList<>();
		cc.getCCVertex(initVertex).parent = null;
		q.add(initVertex);

		Vertex currentVertex = null, adjVertex = null;
		ListIterator<Edge> adjEdges = null;
		while (!q.isEmpty()) {
			currentVertex = q.poll();

			// if the vertice is visited mark them as true.
			cc.getCCVertex(currentVertex).seen = true;

			// gets all the adjacent vertices
			adjEdges = currentVertex.adj.listIterator();
			while (adjEdges.hasNext()) {
				adjVertex = adjEdges.next().otherEnd(currentVertex);
				if (!cc.getCCVertex(adjVertex).seen) {
					q.add(adjVertex);
					// to get the path, we assign next vertice parent as the
					// current vertice
					cc.getCCVertex(adjVertex).parent = currentVertex;
				}
			}
		}

		return currentVertex;
	}

}
