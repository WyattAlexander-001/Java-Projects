package csi213.assignment5;

import java.util.*;

public class AdjacencyMatrix implements Graph {
    private Map<String, Integer> vertexIndices = new HashMap<>();
    private List<VertexImpl> vertices = new ArrayList<>();
    private int[][] matrix;

    public AdjacencyMatrix(int size) {
        matrix = new int[size][size];
    }

    @Override
    public List<? extends Vertex> getVertices() {
        return vertices;
    }

    @Override
    public void addEdge(String name1, String name2, int distance) {
        int index1 = findOrCreateVertexIndex(name1);
        int index2 = findOrCreateVertexIndex(name2);
        matrix[index1][index2] = distance;
        matrix[index2][index1] = distance;
    }
    // Finds the index of a vertex with the given name or creates a new one if it doesn't exist
    private int findOrCreateVertexIndex(String name) {
        return vertexIndices.computeIfAbsent(name, key -> {
            int newIndex = vertices.size();
            vertices.add(new VertexImpl(key, newIndex));
            return newIndex;
        });
    }
    // Vertex implementation for the adjacency matrix
    private class VertexImpl implements Vertex {
        private String name;
        private int index;

        public VertexImpl(String name, int index) {
            this.name = name;
            this.index = index;
        }

        @Override
        public String getName() {
            return name;
        }
        
        // Returns the list of neighboring edges
        @Override
        public List<EdgeImpl> getNeighbors() {
            List<EdgeImpl> neighbors = new ArrayList<>();
            for (int i = 0; i < matrix[index].length; i++) {
                int distance = matrix[index][i];
                if (distance > 0) {
                    neighbors.add(new EdgeImpl(vertices.get(i), distance));
                }
            }
            return neighbors;
        }
    }
    // Edge implementation for the adjacency matrix
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
