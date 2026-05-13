public class Experiment {
    private long bfsTimeSmall, dfsTimeSmall;
    private long bfsTimeMedium, dfsTimeMedium;
    private long bfsTimeLarge, dfsTimeLarge;
    public long[] runTraversals(Graph g) {
        long start = System.nanoTime();
        g.bfs(0);
        long end = System.nanoTime();
        long bfsTime = end - start;

        start = System.nanoTime();
        g.dfs(0);
        end = System.nanoTime();
        long dfsTime = end - start;

        return new long[]{bfsTime, dfsTime};
    }

    public void runMultipleTests() {
        // ---- Small: 10 вершин ----
        System.out.println("=== Small Graph (10 vertices) ===");
        Graph small = GraphFactory.createRandom(10, 20, true);
        small.printGraph();
        long[] t = runTraversals(small);
        bfsTimeSmall = t[0];
        dfsTimeSmall = t[1];

        // ---- Medium: 30 вершин ----
        System.out.println("\n=== Medium Graph (30 vertices) ===");
        Graph medium = GraphFactory.createRandom(30, 80, false);
        long[] t2 = runTraversals(medium);
        bfsTimeMedium = t2[0];
        dfsTimeMedium = t2[1];

        // ---- Large: 100 вершин ----
        System.out.println("\n=== Large Graph (100 vertices) ===");
        Graph large = GraphFactory.createRandom(100, 300, false);
        long[] t3 = runTraversals(large);
        bfsTimeLarge = t3[0];
        dfsTimeLarge = t3[1];
    }

    public void printResults() {
        System.out.println("\n========== Performance Results ==========");
        System.out.printf("%-12s | %-18s | %-18s%n", "Graph Size", "BFS Time (ns)", "DFS Time (ns)");
        System.out.println("-".repeat(54));
        System.out.printf("%-12s | %-18d | %-18d%n", "Small  (10)", bfsTimeSmall, dfsTimeSmall);
        System.out.printf("%-12s | %-18d | %-18d%n", "Medium (30)", bfsTimeMedium, dfsTimeMedium);
        System.out.printf("%-12s | %-18d | %-18d%n", "Large (100)", bfsTimeLarge, dfsTimeLarge);
        System.out.println("=========================================");
    }
}
