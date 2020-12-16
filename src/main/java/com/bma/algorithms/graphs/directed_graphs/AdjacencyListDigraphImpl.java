package com.bma.algorithms.graphs.directed_graphs;

import com.bma.algorithms.graphs.Bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class AdjacencyListDigraphImpl implements Digraph {

    private final int vertices;
    private final Bag<Integer>[] bags;

    public AdjacencyListDigraphImpl(int vertices) {
        this.vertices = vertices;
        this.bags = new Bag[vertices];
        IntStream.range(0, vertices).forEach(vertex -> {
            bags[vertex] = new Bag<>();
        });
    }

    @Override
    public Digraph reverse() {
        return null;
    }

    @Override
    public void addEdge(int fromVertex, int toVertex) {
        bags[fromVertex].add(toVertex);
    }

    @Override
    public Iterable<Integer> adj(int vertex) {
        return bags[vertex];
    }

    @Override
    public int vertices() {
        return vertices;
    }

    @Override
    public int edges() {
        return (int) Arrays.stream(bags).mapToLong(ArrayList::size).sum();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, vertices).forEach(vertex -> {
            sb.append(vertex).append(System.lineSeparator());
            bags[vertex].forEach(directedTo -> sb.append("\t->").append(directedTo).append(System.lineSeparator()));
        });
        return sb.toString();
    }
}