package csi213.assignment5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class UnitTest {
    private Graph adjacencyListGraph;
    private Graph adjacencyMatrix;

    @Before
    public void setUp() {
        adjacencyListGraph = new AdjacencyListGraph();
        adjacencyMatrix = new AdjacencyMatrix(5); // Assuming a maximum of 5 cities in the test graph

        // Create a simple test graph:
        // A --1-- B --1-- C
        adjacencyListGraph.addEdge("A", "B", 1);
        adjacencyListGraph.addEdge("A", "C", 1);
        adjacencyListGraph.addEdge("B", "C", 1);

        adjacencyMatrix.addEdge("A", "B", 1);
        adjacencyMatrix.addEdge("A", "C", 1);
        adjacencyMatrix.addEdge("B", "C", 1);
    }

    @Test
    public void testGraphSize() {
        //assertEquals(3, adjacencyListGraph.getVertices().size());
        assertEquals(3, adjacencyMatrix.getVertices().size());
    }

    @Test
    public void testAddEdge() {
        // Add edge D --1-- E
        adjacencyListGraph.addEdge("D", "E", 1);
        adjacencyMatrix.addEdge("D", "E", 1);

        assertEquals(5, adjacencyListGraph.getVertices().size());
        assertEquals(5, adjacencyMatrix.getVertices().size());
    }

}
