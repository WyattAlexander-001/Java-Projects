package csi213.assignment5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdjacencyListGraphTest {
    private Graph adjacencyListGraph;

    @Before
    public void setUp() {
        adjacencyListGraph = new AdjacencyListGraph();

        // Create a simple test graph:
        // A --1-- B --1-- C
        adjacencyListGraph.addEdge("A", "B", 1);
        adjacencyListGraph.addEdge("A", "C", 1);
        adjacencyListGraph.addEdge("B", "C", 1);
    }

    @Test
    public void testGraphSize() {
        assertEquals(3, adjacencyListGraph.getVertices().size());
    }

    @Test
    public void testAddEdge() {
        // Add edge D --1-- E
        adjacencyListGraph.addEdge("D", "E", 1);

        assertEquals(5, adjacencyListGraph.getVertices().size());
    }
}

