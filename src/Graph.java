import java.util.*;

public class Graph {
    private final Map<Integer, Vertex> vertices = new LinkedHashMap<>();
    private final Map<Integer, List<Integer>> adjacencyList = new LinkedHashMap<>();

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        if (!vertices.containsKey(from)) addVertex(new Vertex(from));
        if (!vertices.containsKey(to))   addVertex(new Vertex(to));

        adjacencyList.get(from).add(to);
    }

    public void printGraph() {
        System.out.println("Graph (adjacency list):");
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }


    public void bfs(int start) {
        Set<Integer> visited = new LinkedHashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        System.out.print("BFS from " + start + ": ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }


    public void dfs(int start) {
        Set<Integer> visited = new LinkedHashSet<>();
        System.out.print("DFS from " + start + ": ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (int neighbor : adjacencyList.getOrDefault(current, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public int vertexCount() {
        return vertices.size();
    }
}
