package io.codingchallenges;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Connected {
	String file = "E:\\workspace\\java-concepts\\core-java\\src\\io\\codingchallenges\\cities.txt";
	Set<String> cities = new LinkedHashSet<>();
	City[] cityArray;
	Stream<String> stream = null;

	public static void main(String[] args) {
		Connected connected = new Connected();
		connected.citiGraph();
	//	connected.print();
		
//		Philadelphia,Pittsburgh
//		Boston,New York
//		Hartford,New York
//		Los Angeles,San Diego
//		New York,Croton-Harmon
//		St. Petersburg,Tampa		
	connected.bfsForConnection("Boston", "Croton-Harmon");
//		connected.bfs();

	}

	public void citiGraph() {

		try {
			stream = Files.lines(Paths.get(file));

		} catch (IOException e) {
			e.printStackTrace();
		}
		stream.forEach(city -> {

			cities.add(city.substring(0, city.indexOf(",")));
			cities.add(city.substring(city.indexOf(",") + 1, city.length()));

		});

		cityArray = new City[cities.size()];
		int counter = 0;

		for (String city : cities) {
			cityArray[counter++] = new City(city, null);
		}

		prepareNeighbors();
	}

	private int indexForName(String name) {
		for (int v = 0; v < cityArray.length; v++) {
			if (cityArray[v].getName().equals(name)) {
				return v;
			}
		}
		return -1;
	}

	private void prepareNeighbors() {
		try {
			stream = Files.lines(Paths.get(file));

		} catch (IOException e) {
			e.printStackTrace();
		}
		stream.forEach(city -> {

			int city1Index = indexForName(city.substring(0, city.indexOf(",")));
			int city2Index = indexForName(city.substring(city.indexOf(",") + 1, city.length()));
			cityArray[city1Index].setAdjCities(new Neighbor(city2Index, cityArray[city1Index].getAdjCities()));
			cityArray[city2Index].setAdjCities(new Neighbor(city1Index, cityArray[city2Index].getAdjCities()));
		});
	}

	public void print() {
		System.out.println();
		for (int v = 0; v < cityArray.length; v++) {
			System.out.print(cityArray[v].getName());
			for (Neighbor nbr = cityArray[v].getAdjCities(); nbr != null; nbr = nbr.getNext()) {
				System.out.print(" --> " + cityArray[nbr.getCityIndex()].getName());
			}
			System.out.println("\n");
		}
	}

	   public void bfs() {
	        boolean[] visited = new boolean[cityArray.length];
	        Queue<Integer> queue = new Queue<Integer>();
	        for (int v=0; v < visited.length; v++) {
	            if (!visited[v]) {
	                System.out.println("\nSTARTING AT " + cityArray[v].getName());
	                queue.clear();
	                bfs(v, visited, queue);
	            }
	        }
	    }
	     
	    // BFS starting at some vertex v
	    private void bfs(int start, boolean[] visited, Queue<Integer> queue ) {
	        visited[start] = true;
	        System.out.println("visiting " + cityArray[start].getName());
	        queue.enqueue(start);
	         
	        while (!queue.isEmpty()) {
	            int v = queue.dequeue();
	            for (Neighbor nbr=cityArray[v].getAdjCities(); nbr != null; nbr=nbr.getNext()) {
	                int vnum = nbr.getCityIndex();
	                if (!visited[vnum]) {
	                    System.out.println("\n" + cityArray[v].getName() + "--" + cityArray[vnum].getName());
	                    visited[vnum] = true;
	                    queue.enqueue(vnum);
	                }
	            }
	        }
		
	    }

	    @SuppressWarnings("unused")
		public void bfsForConnection(String city1, String city2) {
	        boolean[] visited = new boolean[cityArray.length];
	        boolean isConnected = false;
	        Queue<Integer> queue = new Queue<Integer>();
	 
	        
/*	        for (int v=0; v < visited.length; v++) {
	        	if(!isConnected) {
	            if (!visited[v] && !isConnected) {
	            	
	                System.out.println("\nSTARTING AT " + cityArray[v].getName());
	                queue.clear();
	                isConnected=isConnected(v, visited, queue,city1,city2);
	                if(isConnected) {
	                	break;
	                }
	            	}
	            }
	        }
	        */
	        isConnected=isConnected(indexForName(city1), visited, queue,city1,city2);
	    	if (isConnected) {
				System.out.println(city1 + " and " + city2 + " are Connected");
			} else {
				System.out.println(city1 + " and " + city2 + " are  not Connected");
			} 
	    }
	    private boolean isConnected(int start, boolean[] visited, Queue<Integer> queue, String city1, String city2) {
	    	boolean isConnected = false;
	        visited[start] = true;
	        System.out.println("visiting " + cityArray[start].getName());
	        city1 = cityArray[start].getName();
	        queue.enqueue(start);
	         
	        while (!queue.isEmpty()) {
	            int v = queue.dequeue();
	            for (Neighbor nbr=cityArray[v].getAdjCities(); nbr != null; nbr=nbr.getNext()) {
	                int vnum = nbr.getCityIndex();
	                if(city2.equals(cityArray[vnum].getName())) {
	                	isConnected = true;
	                	return isConnected;
	                }
	                if (!visited[vnum]) {
	                    System.out.println("\n" + cityArray[v].getName() + "--" + cityArray[vnum].getName());
	                    visited[vnum] = true;
	                    queue.enqueue(vnum);
	                }
	            }
	        }
			
			return isConnected;
	    }

	
	
}



class City {
	private String name;
	private Neighbor adjCities;

	public City(String name, Neighbor neighbors) {
		this.name = name;
		this.adjCities = neighbors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Neighbor getAdjCities() {
		return adjCities;
	}

	public void setAdjCities(Neighbor adjCities) {
		this.adjCities = adjCities;
	}

}

class Neighbor {
	private int cityIndex; // city Index in the array,
	private Neighbor next;

	public Neighbor(int cityIndex, Neighbor next) {
		this.cityIndex = cityIndex;
		this.next = next;
	}

	public int getCityIndex() {
		return cityIndex;
	}

	public void setCityIndex(int cityIndex) {
		this.cityIndex = cityIndex;
	}

	public Neighbor getNext() {
		return next;
	}

	public void setNext(Neighbor next) {
		this.next = next;
	}
}