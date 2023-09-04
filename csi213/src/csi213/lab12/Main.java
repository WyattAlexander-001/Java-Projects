package csi213.lab12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph g = new Graph();
        var lines = Files.readAllLines(Paths.get("likes.txt")); // read in the file
        for (var line : lines) { // for each line
            var entries = line.split(" "); // split the line into the two names
            g.addEdge(entries[0], entries[1]); // add the edge to the graph
        }

        for (var name : g.getNames()) { // for each unique name in the graph
            var v = g.getVertex(name); // get the vertex for the name
            System.out.print(name + " (");
            for (var a : v.getEdges()) { // for each edge of this vertex
                System.out.print(a.getName() + ", "); // print the name of the edge's other vertex
            }
            System.out.println(")");
        }
    }
}

class Graph { 
    private Map<String, Vertex> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addEdge(String name1, String name2) {
        Vertex vertex1 = vertices.computeIfAbsent(name1, k -> new Vertex(name1));
        Vertex vertex2 = vertices.computeIfAbsent(name2, k -> new Vertex(name2));
        vertex1.addEdge(vertex2);
    }
    
    
    public Set<String> getNames() { // Get the set of all unique names in the graph
        return vertices.keySet();
    }

    public Vertex getVertex(String name) {  // Get the vertex corresponding to a given name
        return vertices.get(name);
    }
}

class Vertex { //Vertex == Person
    private String name;
    private Set<Vertex> edges;

    public Vertex(String name) {
        this.name = name;
        edges = new HashSet<>();
    }

    public void addEdge(Vertex vertex) {
        edges.add(vertex);
    }

    public Set<Vertex> getEdges() {
        return edges;
    }

    public String getName() {
        return name;
    }
}
