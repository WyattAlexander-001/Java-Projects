package csi213.assignment5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdjacencyMatrixTest {
    private Graph adjacencyMatrix;

    @Before
    public void setUp() {
        adjacencyMatrix = new AdjacencyMatrix(5); // Assuming a maximum of 5 cities in the test graph

        // Create a simple test graph:
        // A --1-- B --1-- C
        adjacencyMatrix.addEdge("A", "B", 1);
        adjacencyMatrix.addEdge("A", "C", 1);
        adjacencyMatrix.addEdge("B", "C", 1);
    }

    @Test
    public void testGraphSize() {
        assertEquals(3, adjacencyMatrix.getVertices().size());
    }

    @Test
    public void testAddEdge() {
        // Add edge D --1-- E
        adjacencyMatrix.addEdge("D", "E", 1);

        assertEquals(5, adjacencyMatrix.getVertices().size());
    }
}
