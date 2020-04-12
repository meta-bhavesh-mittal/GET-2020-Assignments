package Session6.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * This class defines functions for implementation of graph.
 * @author Bhavesh Mittal
 *
 */
public class Graph implements GraphInterface
{

    private int numberOfVertices;
    private LinkedList<EdgeAndVertices> listOfEdges[];
    private EdgeAndVertices edge;
    private List<EdgeAndVertices> edges;

    public LinkedList<EdgeAndVertices>[] getListOfEdges() {
        return listOfEdges;
    }

    // Constructor to initialize graph with number of vertices and list of edges
    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;

        listOfEdges = new LinkedList[numberOfVertices];

        // Initializing the list of vertices
        for (int i = 0; i < this.numberOfVertices; i++) {
            listOfEdges[i] = new LinkedList<>();
        }
    }
    
    /**
     * Function to add edges in graph in case of weighted undirected graph
     * 
     * @param source
     * @param destination
     * @param weight
     */
    public void addEdge(int source, int destination, int weight) {
        // source is connected to destination
        edge = new EdgeAndVertices(source, destination, weight);
        listOfEdges[source].addFirst(edge);
        // destination is also connected to source
        edge = new EdgeAndVertices(destination, source, weight);
        listOfEdges[destination].addFirst(edge);
    }

    /**
     * Helper function to print a graph
     */
    public void printGraph() {
        for (int count_i = 0; count_i < numberOfVertices; count_i++) {
            edges = listOfEdges[count_i];
            for (int count_j = 0; count_j < edges.size(); count_j++) {
                System.out.println("vertex-" + count_i + " is connected to "
                        + edges.get(count_j).getDestination() + " with weight "
                        + edges.get(count_j).getWeight());
            }
        }
    }

    /**
     * method to find DFS of graph
     * @param v
     * @param state
     */
    public void dfs(int v,boolean state[]) {
  
            state[v] = true; 
            // Recur for all the vertices adjacent to this vertex 
            Iterator<EdgeAndVertices> iterator = listOfEdges[v].listIterator(); 
            while (iterator.hasNext()) 
            { 
            	EdgeAndVertices n = iterator.next(); 
                if (!state[n.getDestination()]) 
                    dfs(n.getDestination() ,state); 
            } 
    	
    }
    
    @Override
    public boolean isConnected() {
    	
    	boolean state[] = new boolean[this.numberOfVertices];
    	dfs(0,state);
    	for (int index = 0; index < numberOfVertices; index++) {

    		if (state[index] == false)
    			return false;
    	}
    	return true;
    }
    
    @Override
    public List<Integer> reachable(int vertex) {

        if (vertex >= numberOfVertices) {
            throw new AssertionError("Vertex not in graph");
        }
        List<Integer> listOfReachableVertex = new ArrayList<Integer>();
        
        boolean state[] = new boolean[this.numberOfVertices];
        
    	dfs(vertex,state);
    	for (int index = 0; index < numberOfVertices; index++) {

    		if (state[index] == true)
    			listOfReachableVertex.add(index);
    	}
        
        if (listOfReachableVertex.size() == 0) {
            return null;
        }
        return listOfReachableVertex;
    }

    /**
     * Helper function to find the vertex with minimum key value,
     * from the set of vertices not yet included in MST
     * @param key
     * @param boolSet
     * @return
     */
    int minKey(int key[], Boolean boolSet[]) {
        // Initialize minimum value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int count_i = 0; count_i < numberOfVertices; count_i++)
            if (boolSet[count_i] == false && key[count_i] < min) {
                min = key[count_i];
                min_index = count_i;
            }

        return min_index;
    }
    
    @Override
    public List<EdgeAndVertices> minimumSpanningTree() {

        List<EdgeAndVertices> minSpanningtree;

        int parent[] = new int[numberOfVertices];
        int key[] = new int[numberOfVertices];
        Boolean mstSet[] = new Boolean[numberOfVertices];

        // Initialize all keys as INFINITE
        for (int count_i = 0; count_i < numberOfVertices; count_i++) {
            key[count_i] = Integer.MAX_VALUE;
            mstSet[count_i] = false;
        }

        key[0] = 0; 
        parent[0] = -1; 

        for (int count_i = 0; count_i < numberOfVertices - 1; count_i++) {

            int min = minKey(key, mstSet);
            mstSet[min] = true;

            edges = listOfEdges[min];

            for (int count_j = 0; count_j < numberOfVertices; count_j++) {

                for (EdgeAndVertices listEdges : edges) {

                    if (listEdges.getDestination() == count_j) {
                        if (listEdges.getWeight() != 0 && !mstSet[count_j]
                                && listEdges.getWeight() < key[count_j]) {

                            parent[count_j] = min;
                            key[count_j] = listEdges.getWeight();

                        }
                    }
                }
            }
        }

        minSpanningtree = new ArrayList<>();

        for (int count_i = 1; count_i < numberOfVertices; count_i++) {
            edges = listOfEdges[count_i];
            for (EdgeAndVertices edgeConnected : edges) {

                if (edgeConnected.getDestination() == parent[count_i]) {
                    edge = new EdgeAndVertices(parent[count_i], count_i, edgeConnected.getWeight());
                    minSpanningtree.add(edge);
                }
            }
        }

        return minSpanningtree;
    }

    @Override
    public List<EdgeAndVertices> shortestPath(int source, int destination) {
        List<EdgeAndVertices> shortestPath;

        int dist[] = new int[numberOfVertices];
       
        Boolean sptSet[] = new Boolean[numberOfVertices];

        for (int count_i = 0; count_i < numberOfVertices; count_i++) {
            dist[count_i] = Integer.MAX_VALUE;
            sptSet[count_i] = false;
        }

        dist[source] = 0;

        for (int count_i = 0; count_i < numberOfVertices - 1; count_i++) {
          
            int min = minKey(dist, sptSet);
            sptSet[min] = true;
            edges = listOfEdges[min];
            
            for (int count_j = 0; count_j < numberOfVertices; count_j++) {

                for (EdgeAndVertices listEdges : edges) {
                    // getting weight connected with vertex v
                    if (listEdges.getDestination() == count_j) {

                        if (!sptSet[count_j] && listEdges.getWeight() != 0
                                && dist[min] != Integer.MAX_VALUE
                                && dist[min] + listEdges.getWeight() < dist[count_j]) {

                            dist[count_j] = dist[min] + listEdges.getWeight();
                        }
                    }
                }
            }
        }

        shortestPath = new ArrayList<>();

        for (int count_i = source; count_i < destination + 1; count_i++) {
            edge = new EdgeAndVertices(count_i - 1, count_i, dist[count_i]);
            shortestPath.add(edge);
        }
        return shortestPath;
    }
  
}