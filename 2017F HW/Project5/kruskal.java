/**
 * kruskal's algorithm
 * Use disjSets to find a shortest path.
 * @author simonwang
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.lang.Comparable;

public class kruskal {

	public static void main(String[] args) {
		//create edge & store edge into pq
		kruskal graph = new kruskal(); 
		
		//Connect all the edges
		graph.kruskalConnect(); 
		
	}
	
	//pq use to store all edges
	private PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	//map use to store the City's name and its named number
	private Map<Integer,String> map;  
	
	//create edge & store edge into pq
	public kruskal() {
		map = new HashMap<Integer,String>();
		
		// Read file to data structures
		File file = new File("src/assn9_data.csv");
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String cvsString;
		String cvsSplit = ",";
		try {
			int CityNum=0;
			while ((cvsString = buffer.readLine()) != null) { 
				//Use "," to seperate each data 
				String[] city = cvsString.split(cvsSplit);
//				System.out.println("Country [" + city[0] + "]");
				
				//Name the City into Number : ( Key, "City Name"), and store into map
				map.put(CityNum++, city[0]); 
			}	
			buffer.close();
			
			System.out.println("############ Read All Edges ###############");
			try {
				buffer = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			//Store edge into pq
			while ((cvsString = buffer.readLine()) != null) { 
				//City's number
				int CityNum2=0;
				//Each word in each line
				int lineNum=1;
				//Each integer in each line
				int intNum=2;
				String[] city = cvsString.split(cvsSplit);
				
				//Storing all edges( vertices1, vertices2, weight)
				while(lineNum < city.length) {
					int weight = Integer.parseInt(cvsString.split(",")[intNum]);
					System.out.println("Country [" + city[0] + " , " + city[lineNum] + " , " + "Weight=" + weight + "]");
					
					//Add edges into pq
					//Edge(vertice 1, vertice 2, Weight) = Edge(City1 Key, City2 Key, Weight)
					pq.add(new Edge(getKey(map,city[CityNum2]), getKey(map,city[lineNum]), weight)); 
					
					lineNum+=2;
					intNum+=2;	
				}	
				CityNum2++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//End read
		try { 
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//print City(Map) Number
		System.out.println();
		System.out.println("############# City's Number ###############");
		for(Map.Entry m:map.entrySet()) { 
			System.out.println(m.getKey() +","+ m.getValue());  
		}
		
		//print PriorityQueue
		System.out.println();
		System.out.println("############ Priority Queue ###############");
		System.out.println(pq);
		
	}

	
	public void kruskalConnect() {
	    int edgesAccepted = 0;
	    int NUM_VERTICES = map.size();
	    int distance = 0; 
	    Edge edge;
	    
	    //Initial all vertices values in DisjSets Array to -1; -1 mean all are roots 
	    DisjSets ds = new DisjSets(NUM_VERTICES); 
	    
	    System.out.println();
	    System.out.println("################ Final Graph ##############");
	    while (edgesAccepted < (NUM_VERTICES - 1)) {
	    		// get minimum edge = (u,v); (Object vertice1, Object vertice2), Weight= int weight
	        edge = pq.remove( );  
	        
	        // find root of vertice1
	        int uset = ds.find((int)edge.vertice1); 
	        // find root of vertice2
	        int vset = ds.find( (int)edge.vertice2); 
	        
	        // if not same set (not yet connected)
	        if (uset != vset) {
	             // accept the edge
	             edgesAccepted++;
	             
	             // connect them
	             ds.union(uset, vset); 
//	             System.out.println(uset + "," + vset);
	             System.out.println("(" + map.get(edge.vertice1) + ", " + map.get(edge.vertice2) + "), Weight=" + edge.weight);
	             distance +=  edge.weight;	             
	         }
	   }
	   System.out.println();
	   System.out.println("Total Distance :" + distance);
	}
	
	//Get Key value from map
	private int getKey(Map<Integer, String> map, Object value) {
		for(Integer key : map.keySet()) {
			if(map.get(key).equals(value)) {
				//return the first found
				return key; 
			}
		}
		return 999; 
	}
	
	// A class of a graph edge
    class Edge implements Comparable<Edge> {
    		//An edge has 2 vertices and a weight
	    	private Object vertice1;	
	    	private Object vertice2;
	    	private int weight;
	
	    	public Edge(Object vertice1, Object vertice2, int weight) {
	    		this.vertice1=vertice1;
	    		this.vertice2=vertice2;
	    		this.weight=weight;
	    	}
	
	    	public int getWeight() {
	    		return weight;
	    	}
	    	
	    	public Object getVertice1() {
	    		return vertice1;
	    	}
	
	    	public Object getVertice2() {
	    		return vertice2;
	    	}
	
	    	@Override
	    	//Sorting, weight small to large number
	    	public int compareTo(Edge otherEdge) {	
	    		return this.getWeight() - otherEdge.getWeight();
	    	}
	
	    	@Override
	    	public String toString() {	
	    		return "[" + "(" + getVertice1() + ", " + getVertice2() + "), Weight=" + getWeight() + "] ";
	    	}
    }; 

}
