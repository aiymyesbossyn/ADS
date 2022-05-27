package graph;

import java.util.*;

public class Search<T> {
    protected int count;
    protected Set<Vertex<T>> marked;
    protected Map<Vertex<T>, Vertex<T>> edgeTo;
    protected final Vertex<T> source;

    public Search(Vertex<T> source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<T> vertex) {
        return marked.contains(vertex);
    }

    public Iterable<Vertex<T>> pathTo(Vertex<T> vertex) {
        if (!hasPathTo(vertex)) {
            return null;
        } else {
            LinkedList<Vertex<T>> vertexList = new LinkedList<>();
            Vertex<T> temp = vertex;

            while (temp != source) {
                vertexList.push(temp);
                temp = edgeTo.get(temp);
            }

            vertexList.push(source);

            return vertexList;
        }

    }

    public int getCount() {
        return count;
    }
}
