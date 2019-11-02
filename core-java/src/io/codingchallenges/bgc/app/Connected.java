package io.codingchallenges.bgc.app;

import java.io.FileNotFoundException;

import io.codingchallenges.bgc.ds.Graph;

public class Connected {

	public static void main(String[] args) {
		boolean isConnected = false;
		if (args.length != 3) {
			System.out.println("Please Suppiy all Parameter, either fileName or firstCity or secondCity is mising");
			System.exit(0);
		}
		Graph graph = new Graph(args[0]);
		try {
			graph.buildCityGraph();
		} catch (FileNotFoundException e) {
			System.out.println("Please check file "+ e.getMessage());
		}
		isConnected = graph.isConntected(args[1], args[2]);
		if (isConnected) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
