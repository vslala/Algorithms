package com.bma.algorithms.undirected_graphs;

import java.util.stream.IntStream;

public class CC implements ConnectedComponents {

    private int count;
    private int[] id;
    private boolean[] marked;

    public CC(GraphApi graph) {
        marked = new boolean[graph.vertices()];
        id = new int[graph.vertices()];
        IntStream.range(0, graph.vertices()).forEach(vertex -> {
            if (! marked[vertex]) {
                dfs(graph, vertex);
                count++;
            }
        });
    }

    private void dfs(GraphApi graph, int vertex) {
        marked[vertex] = true;
        id[vertex] = count; // assign id to the vertex to check if it belongs to the same connected component
        graph.adj(vertex).forEach(adjVertex -> {
            if (! marked[adjVertex])
                dfs(graph, adjVertex);
        });
    }

    @Override
    public boolean connected(int sourceVertex, int destVertex) {
        return id[sourceVertex] == id[destVertex];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int id(int vertex) {
        return id[vertex];
    }
}
