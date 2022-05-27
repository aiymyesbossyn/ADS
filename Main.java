package graph;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        Vertex<String> vertexAlmaty = new Vertex<>("Almaty");
        Vertex<String> vertexAstana = new Vertex<>("Astana");
        Vertex<String> vertexShymkent = new Vertex<>("Shymkent");
        Vertex<String> vertexQostanay = new Vertex<>("Qostanay");
        Vertex<String> vertexQyzylorda = new Vertex<>("Qyzylorda");

        graph.addEdge(vertexAlmaty, vertexAstana, 2.1);
        graph.addEdge(vertexAlmaty, vertexAstana, 7.2);
        graph.addEdge(vertexShymkent, vertexAstana, 3.9);
        graph.addEdge(vertexAstana, vertexQostanay, 3.5);
        graph.addEdge(vertexShymkent, vertexQyzylorda, 5.4);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graph, vertexAlmaty);
        outputPath(djk, vertexQyzylorda);

        System.out.println();
        System.out.println("---------------------------");
        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, vertexAlmaty);
        outputPath(bfs, vertexQyzylorda);
    }

    public static void outputPath(Search<String> search, Vertex<String> key) {
        for (Vertex<String> vertex : search.pathTo(key)) {
            System.out.print(vertex.getData() + " -> ");
        }
    }
}
