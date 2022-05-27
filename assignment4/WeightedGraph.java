package graph;

import java.util.*;

public class WeightedGraph<T> {
    private boolean undirected;
    private List<Vertex<T>> vertices = new ArrayList<>();

    WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<T> source, Vertex<T> target, double weight) {
        if (!hasVertex(source)) addVertex(source);

        if (!hasVertex(target)) addVertex(target);

        if (hasEdge(source, target) || source.equals(target)) return;

        if (!undirected) {
            vertices.stream()
                    .filter(element -> element.getData().equals(source)
                            && !hasEdge(source, target))
                    .forEachOrdered(element -> element.addAdjacentVertex(target, weight));
        } else {
            vertices.forEach(element -> {
                if (element.equals(source) && !hasEdge(source, target)) {
                    element.addAdjacentVertex(target, weight);
                }
                if (element.equals(target) && !hasEdge(target, source)) {
                    element.addAdjacentVertex(source, weight);
                }
            });
        }

    }

    public boolean hasVertex(Vertex<T> vertex) {
        for (Vertex<T> element : vertices) {
            if (element.getData().equals(vertex.getData())) {
                return true;
            }
        }

        return false;
    }

    public boolean hasEdge(Vertex<T> destinationFrom, Vertex<T> destinationTo) {
        if (!hasVertex(destinationFrom)) {
            return false;
        }

        for (Vertex<T> element : vertices) {
            if (element.getData().equals(destinationFrom) && element.getAdjacentVertices() != null) {
                for (Vertex<T> elementVertex : element.getAdjacentVertices().keySet()) {
                    if (elementVertex.getData().equals(destinationTo)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public List<Vertex<T>> adjacencyList(Vertex<T> vertex) {
        if (!hasVertex(vertex)) {
            return null;
        }

        List<Vertex<T>> vertexLinkedList = new LinkedList<>();

        for (Vertex<T> element : this.vertices) {
            if (element.getData().equals(vertex.getData())) {
                vertexLinkedList.addAll(element.getAdjacentVertices().keySet());
                break;
            }
        }

        return vertexLinkedList;
    }

    public Map<Vertex<T>, Double> getEdges(Vertex<T> vertex) {
        if (!hasVertex(vertex)) {
            return null;
        }

        for (Vertex<T> element : vertices) {
            if (element.getData().equals(vertex.getData())) {
                return Optional.of(element).map(Vertex::getAdjacentVertices).orElse(null);
            }
        }
        return null;
    }
}
