package csi213.assignment5;

import java.util.*;

public class AdjacencyListGraph implements Graph {
    private Map<String, VertexImpl> vertices = new HashMap<>();

    @Override
    public List<? extends Vertex> getVertices() {
        return new ArrayList<>(vertices.values());
    }

    @Override
    public void addEdge(String name1, String name2, int distance) {
        VertexImpl vertex1 = vertices.computeIfAbsent(name1, VertexImpl::new);
        VertexImpl vertex2 = vertices.computeIfAbsent(name2, VertexImpl::new);
        vertex1.addEdge(new EdgeImpl(vertex2, distance));
        vertex2.addEdge(new EdgeImpl(vertex1, distance));
    }
    // Vertex implementation for the adjacency list
    private static class VertexImpl implements Vertex {
        private String name;
        private List<EdgeImpl> edges = new ArrayList<>();

        public VertexImpl(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
        // Returns the list of neighboring edges
        @Override
        public List<? extends Edge> getNeighbors() {
            return edges;
        }

        public void addEdge(EdgeImpl edge) {
            edges.add(edge);
        }
    }
    // Edge implementation for the adjacency list
    private static class EdgeImpl implements Edge {
        private Vertex destination;
        private int distance;

        public EdgeImpl(Vertex destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }

        @Override
        public int getDistance() {
            return distance;
        }

        @Override
        public Vertex getDestination() {
            return destination;
        }
    }
}
