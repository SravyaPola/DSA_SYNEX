package graphs;

import java.util.*;

public class GraphTraversal {
	public static void main(String[] args) {
		String[] vertices = { "V1", "V2", "V3", "V4", "V5", "V6" };
		String[][] edges = { { "V1", "V2" }, { "V1", "V4" }, { "V2", "V3" }, { "V2", "V6" }, { "V3", "V5" },
				{ "V3", "V6" }, { "V4", "V3" }, { "V4", "V5" } };
		Map<String, List<String>> adjList = new HashMap<>();
		for (String v : vertices) {
			adjList.put(v, new ArrayList<>());
		}
		for (String[] e : edges) {
			String src = e[0], dest = e[1];
			adjList.get(src).add(dest);
		}
		List<String> bfsOrder = bfs("V1", adjList);
		List<String> dfsOrder = dfs("V1", adjList);
		System.out.println("bfsOrder : " + bfsOrder);
		System.out.println("dfsOrder : " + dfsOrder);
	}

	private static List<String> dfs(String start, Map<String, List<String>> adjList) {
		Set<String> visited = new HashSet<>();
		List<String> result = new ArrayList<>();
		dfshelper(adjList, visited, start, result);
		return result;
	}

	private static void dfshelper(Map<String, List<String>> adjList, Set<String> visited, String start,
			List<String> result) {
		visited.add(start);
		result.add(start);
		for (String i : adjList.get(start)) {
			if (!visited.contains(i)) {
				dfshelper(adjList, visited, i, result);
			}
		}
	}

	private static List<String> bfs(String start, Map<String, List<String>> adjList) {
		List<String> bfs = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		visited.add(start);
		queue.add(start);
		while (!queue.isEmpty()) {
			String curr = queue.poll();
			bfs.add(curr);
			for (String str : adjList.get(curr)) {
				if (!visited.contains(str)) {
					visited.add(str);
					queue.add(str);
				}
			}
		}
		return bfs;
	}
}
