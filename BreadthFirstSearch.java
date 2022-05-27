package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> extends Search<T> {
    public BreadthFirstSearch(WeightedGraph<T> graph, Vertex<T> v) {
        super(v);
        bfs(graph, v);
    }

    private void bfs(WeightedGraph<T> graph, Vertex<T> vertex)
    {
        Queue<Vertex<T>> vertices = new LinkedList<>();
        marked.add(vertex);
        vertices.add(vertex);

        while (!vertices.isEmpty()) {
            Vertex<T> temp = vertices.remove();

            graph.adjacencyList(temp)
                    .stream()
                    .filter(element -> !marked.contains(element)).forEachOrdered(element -> {
                vertices.add(element);
                edgeTo.put(element, temp);
                marked.add(element);
            });
        }
    }
}
   $ git reset --hard a3775a5485af0af20375cedf46112db5f813322a 
    $ git push --force
