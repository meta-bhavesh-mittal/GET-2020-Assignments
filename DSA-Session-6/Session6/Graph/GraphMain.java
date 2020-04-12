package Session6.Graph;

import java.util.*;
/**
 * This is main driver function of graph.
 * @author Bhavesh Mittal
 */
public class GraphMain
{
    public static void main(String args[]) {
    	
    	Scanner inputObj = new Scanner(System.in) ;
    	
    	int vertices,edges ;
    	System.out.println("Enter the number of vertices in graph :");
    	vertices = inputObj.nextInt();
    	System.out.println("Enter the number of edges in graph :");
    	edges = inputObj.nextInt();
    	
        Graph graph = new Graph(vertices);
        
        int source , destination,weight ;
        
        for(int count_i=0;count_i<edges;count_i++){
        	System.out.println("Enter details of edge : "+count_i);
        	System.out.print("source : ");
        	source = inputObj.nextInt();
        	System.out.print("destination : ");
        	destination = inputObj.nextInt();
        	System.out.print("weight : ");
        	weight = inputObj.nextInt();
        	graph.addEdge(source,destination,weight);
        }
        
        System.out.println("Graph created.. ");
       
        graph.printGraph();
        

        System.out.println("\nIs graph connected ? "+"\nAnswer : "+graph.isConnected());

        System.out.println("\nchecking reachable vertices from given vertex ..");
        
        System.out.println("enter vertex : ");
        source = inputObj.nextInt();
        List<Integer> listOfReachable = graph.reachable(source);
        System.out.println("reachable vertices are : "+listOfReachable.toString());

        
        System.out.println("\nThe minimum spanning tree is : \n");
        List<EdgeAndVertices> mst = graph.minimumSpanningTree();
        mst.forEach(mstList -> System.out.println(" Source: "
                + mstList.getSource() + " Destination: "
                + mstList.getDestination() + " Weight: " + mstList.getWeight()));

        
        System.out.println("\nFinding shortest path ..");
        System.out.print("enter source : ");
    	source = inputObj.nextInt();
    	System.out.print("enter destination : ");
    	destination = inputObj.nextInt();
        List<EdgeAndVertices> spt = graph.shortestPath(source, destination);

        spt.forEach(sptList -> System.out.println(" Source : "
                + sptList.getSource() + " Destination : "
                + sptList.getDestination() + " Distance : " + sptList.getWeight()));

    }
}