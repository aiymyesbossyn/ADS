package graph;

import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Map<Vertex<T>, Double> distances;
    private final Set<Vertex<T>> unsettledNodes;
    private final WeightedGraph<T> graph;

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> vertex) {
        super(vertex);
        this.graph = graph;
        distances = new HashMap<>();
        unsettledNodes = new HashSet<>();
        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (unsettledNodes.size() > 0) {
            Vertex<T> v = getVertexWithMinimumWeight(unsettledNodes);
            marked.add(v);
            unsettledNodes.remove(v);

            graph.adjacencyList(v)
                    .stream()
                    .filter(element -> getShortestDistance(element) > getShortestDistance(v) + getDistance(v, element))
                    .forEach(element -> {
                        distances.put(element, getShortestDistance(v) + getDistance(v, element));
                        edgeTo.put(element, v);
                        unsettledNodes.add(element);
                    });
        }
    }

    private double getDistance(Vertex<T> source, Vertex<T> target) {
        for (Vertex<T> element : graph.getEdges(source).keySet()) {
            if (element.equals(target)) {
                return graph.getEdges(source).get(element);
            }
        }

        throw new RuntimeException("Not found!");
    }

    private Vertex<T> getVertexWithMinimumWeight(Set<Vertex<T>> vertices) {
        Vertex<T> minimum = null;

        for (Vertex<T> vertex : vertices) {
            if (minimum != null) {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            } else {
                minimum = vertex;
            }
        }

        return minimum;
    }

    private double getShortestDistance(Vertex<T> destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}
