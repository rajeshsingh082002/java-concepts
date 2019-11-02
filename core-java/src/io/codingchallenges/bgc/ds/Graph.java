package io.codingchallenges.bgc.ds;

import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import io.codingchallenges.bgc.util.GraphUtil;

public class Graph {
	private Map<String, City> cityMap = new HashMap<>(); // Adjacency maatrix for holding path beteen citits
	private Map<String, Boolean> VisitedNodes = new HashMap<>();
	private String fileName;
	
	public Graph(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Takes the file name and create graph from that
	 * 
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 */
	public Map buildCityGraph() throws FileNotFoundException {
		String cityName1, cityName2;
		City cityOne, cityTwo;
		Scanner scanner = new Scanner(GraphUtil.getFilePath(fileName));
		String[] pair;
		while (scanner.hasNextLine()) {
			pair = scanner.nextLine().split(",");
			if (pair.length != 2) {
				System.out.println("Input file is malformd");
				System.exit(0);
			}
			cityName1 = pair[0];
			cityName2 = pair[1];
			VisitedNodes.put(cityName1, false);
			VisitedNodes.put(cityName2, false);
			if(cityMap.get(cityName1) == null) {
				cityOne = new City(cityName1);
				cityTwo = new City(cityName2);
				cityOne.getNeighbors().add(cityTwo);
				cityMap.put(cityName1, cityOne);
			} else {
				cityTwo = new City(cityName2);
				City city = cityMap.get(cityName1);
				city.getNeighbors().add(cityTwo);
				cityMap.put(cityName1, city);
			}
			
			
			if(cityMap.get(cityName2) == null) {
				cityOne = new City(cityName1);
				cityTwo = new City(cityName2);
				cityTwo.getNeighbors().add(cityOne);
				cityMap.put(cityName2, cityTwo);
			} else {
				cityOne = new City(cityName1);
				City city = cityMap.get(cityName2);
				city.getNeighbors().add(cityOne);
				cityMap.put(cityName2, city);
			}
		}
		return cityMap;
	}
	
	public void bfs(String start ) {
		boolean isConnected = false;
		Deque<String> queue = new LinkedList<>();
		queue.push(start);
		while(!queue.isEmpty()) {
			String cityName = queue.pollFirst();
			VisitedNodes.put(cityName, true);
			City city = cityMap.get(cityName);
			System.out.println("visting Node: "+city.getName());
			List<City> neighbors = city.getNeighbors();
			for (City neighbor : neighbors) {
				if(!VisitedNodes.get(neighbor.getName())) {
					
					 System.out.println("-->"+neighbor.getName());
					 queue.push(neighbor.getName());
				}
				System.out.println();
				
			}
		}
		
	}
	
	public boolean isConntected(String city1, String city2) {
		boolean isConnected = false;
		Deque<String> queue = new LinkedList<>();
		queue.push(city1);
		while(!queue.isEmpty()) {
			String cityName = queue.pollFirst();
			VisitedNodes.put(cityName, true);
			City city = cityMap.get(cityName);
			List<City> neighbors = city.getNeighbors();
			for (City neighbor : neighbors) {
				if(!VisitedNodes.get(neighbor.getName())) {
					queue.push(neighbor.getName());
					if(city.getName().equals(city2) || neighbor.getName().endsWith(city2)) {
						isConnected = true;
						break;
					}
				}
				
			}
		}
		
		return isConnected;
	}

}

class City {
	private String name;
	private List<City> neighbors;

	public City(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getNeighbors() {
		if (neighbors == null) {
			neighbors = new LinkedList<>();
		}
		return neighbors;
	}

	public void setNeighbors(List<City> neighbors) {
		this.neighbors = neighbors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
