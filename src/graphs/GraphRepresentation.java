package graphs;

//String[] vertex = {"V1", "V2", "V3", "V4", "V5", "V6"};
//String[][] edges = {{"V1","V2"}, {"V1","V4"},{"V2","V3"}, {"V2","V6"}, {"V3","V5"}, {"V3","V6"}, {"V4","V3"}, {"V4","V5"}};
import java.util.*;

public class GraphRepresentation {

	public static void main(String[] args) {
		String[] vertices = { "V1", "V2", "V3", "V4", "V5", "V6" };
		String[][] edges = { { "V1", "V2" }, { "V1", "V4" }, { "V2", "V3" }, { "V2", "V6" }, { "V3", "V5" },
				{ "V3", "V6" }, { "V4", "V3" }, { "V4", "V5" } };
		Map<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < vertices.length; i++) {
			hm.put(vertices[i], i);
		}
		int n = vertices.length;
		int[][] adjMatrix = new int[n][n];
		for (String[] e : edges) {
			int a = hm.get(e[0]);
			int b = hm.get(e[1]);
			adjMatrix[a][b] = 1;
		}
		System.out.println("Adjacency Matrix:");
		System.out.print("    ");
		for (String v : vertices)
			System.out.printf("%3s", v);
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.printf("%3s ", vertices[i]);
			for (int j = 0; j < n; j++) {
				System.out.printf("%3d", adjMatrix[i][j]);
			}
			System.out.println();
		}
		List<List<String>> adjList = new ArrayList<>();
		for (int i = 0; i < vertices.length; i++) {
			adjList.add(new ArrayList<>());
		}
		for (String[] e : edges) {
			int a = hm.get(e[0]);
			adjList.get(a).add(e[1]);
		}
		System.out.println("\nAdjacency List:");
		for (int i = 0; i < n; i++) {
			System.out.print(vertices[i] + ": ");
			System.out.println(adjList.get(i));
		}
	}
}
