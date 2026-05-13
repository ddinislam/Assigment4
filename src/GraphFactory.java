import java.util.Random;

/**
 * GraphFactory — вспомогательный класс для генерации случайных графов.
 */
public class GraphFactory {

    /**
     * Создать случайный граф с n вершинами и примерно edgeCount рёбрами.
     * @param n          количество вершин
     * @param edgeCount  желаемое количество рёбер
     * @param print      нужно ли выводить граф на экран
     */
    public static Graph createRandom(int n, int edgeCount, boolean print) {
        Graph g = new Graph();
        for (int i = 0; i < n; i++) g.addVertex(new Vertex(i));

        Random rnd = new Random(42);
        int added = 0;
        while (added < edgeCount) {
            int from = rnd.nextInt(n);
            int to   = rnd.nextInt(n);
            if (from != to) {
                g.addEdge(from, to);
                added++;
            }
        }
        return g;
    }
}
