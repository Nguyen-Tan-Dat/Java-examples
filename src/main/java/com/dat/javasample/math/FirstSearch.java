package com.dat.javasample.math;

import java.util.*;

public class FirstSearch {
	HashMap<String, LinkedList<String>> adjacent = new HashMap<>();
	public FirstSearch() {
	}

	public void addEdge(String vertices1, String vertices2) {
		adjacent.computeIfAbsent(vertices1, k -> new LinkedList<>());
		adjacent.get(vertices1).add(vertices2);
	}

	public ArrayList<String> DFS(String root) {
		ArrayList<String> result = new ArrayList<>();
		HashSet<String> pass = new HashSet<>();
		Stack<String> stack = new Stack<>();
		stack.push(root);
		while (!stack.empty()) {
			root = stack.peek();
			stack.pop();
			if (!pass.contains(root)) {
				result.add(root);
				pass.add(root);
			}
			if (adjacent.containsKey(root))
				for (var a : adjacent.get(root))
					if (!pass.contains(a)) {
						stack.push(a);
					}
		}
		return result;
	}
	public ArrayList<String> BFS(String root) {
		ArrayList<String> result = new ArrayList<>();
		HashSet<String> pass = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		pass.add(root);
		queue.add(root);
		while (!queue.isEmpty()) {
			root = queue.poll();
			result.add(root);
			if (adjacent.containsKey(root))
				for (String n : adjacent.get(root)) {
					if (!pass.contains(n)) {
						pass.add(n);
						queue.add(n);
					}
				}
		}
		return result;
	}

	public static void main(String[] args) {
		FirstSearch g = new FirstSearch();
		g.addEdge("0", "1");
		g.addEdge("0", "3");
		g.addEdge("1", "2");
		g.addEdge("1", "5");
		g.addEdge("1", "3");
		g.addEdge("1", "6");
		g.addEdge("2", "3");
		g.addEdge("2", "4");
		g.addEdge("2", "5");
		g.addEdge("3", "4");
		g.addEdge("4", "6");
		var rs1 = g.DFS("0");
		var rs = g.BFS("0");
		for (String i : rs1)
			System.out.print(i + "\t");
		System.out.println();
		for(String i:rs)
			System.out.print(i+"\t");
	}
}
