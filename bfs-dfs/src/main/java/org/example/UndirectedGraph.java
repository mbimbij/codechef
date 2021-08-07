package org.example;

import lombok.Value;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UndirectedGraph {
    private Set<String> nodeIds;
    private Set<Edge> edges;

    private UndirectedGraph(Set<String> nodeIds, Set<Edge> edges) {
        this.nodeIds = nodeIds;
        this.edges = edges;
    }

    int getNumberOfEdges(){
        return edges.size();
    }

    int getNumberOfNodes(){
        return nodeIds.size();
    }

    @Value
    public static class Edge {
        Set<String> nodes = new HashSet<>(2, 1.0f);

        public Edge(String node1, String node2) {
            nodes.add(node1);
            nodes.add(node2);
        }

        public boolean contains(String nodeId) {
//            return Objects.equals(node1, nodeId) || Objects.equals(node2, nodeId);
            return nodes.contains(nodeId);
        }
    }

    public static Builder anUndirectedGraph(){
        return new Builder();
    }

    public static class Builder {
        public Set<String> nodeIds;
        private Set<Edge> edges = new HashSet<>();

        public Builder withNodes(String... nodeIds) {
            this.nodeIds = Arrays.stream(nodeIds).collect(Collectors.toSet());
            return this;
        }

        public Builder withEdges(UndirectedGraph.Edge... edges) {
            this.edges.addAll(Arrays.asList(edges));
            return this;
        }

        public UndirectedGraph build(){
            return new UndirectedGraph(nodeIds, edges);
        }
    }
}
