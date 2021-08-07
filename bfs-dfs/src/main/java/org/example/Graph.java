package org.example;

import lombok.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class Graph {
    public Map<String, Node> nodes;

    private Graph(Map<String, Node> nodes) {
        this.nodes = nodes;
    }

    public static Graph.Builder builder() {
        return new Graph.Builder();
    }

    public String[] dfsPath(String nodeIdFrom, String nodeIdTo) {
        return dfsPathInner(nodeIdFrom, nodeIdTo, new ArrayList<>()).toArray(new String[0]);
    }

    public List<String> dfsPathInner(String nodeIdFrom, String nodeIdTo, List<String> context) {
        context.add(nodeIdFrom);
        return context;
    }

    public static class Builder {
        public Map<String, Node> nodes;

        public static Edge anEdge(String nodeIdFrom, String nodeIdTo) {
            return new Edge(nodeIdFrom, nodeIdTo);
        }

        public Graph build() {
            return new Graph(nodes);
        }

        public Builder withNodes(String... nodeIds) {
            nodes = Arrays.stream(nodeIds)
                    .map(Node::new)
                    .collect(Collectors.toMap(
                            Node::getNodeId,
                            identity()
                    ));
            return this;
        }

        public Builder withEdges(Edge... edges) {
            Arrays.stream(edges)
                    .forEach(edge -> {
                        Node nodeFrom = nodes.get(edge.from);
                        Node nodeTo = nodes.get(edge.to);
                        nodeFrom.addAdjacentNode(nodeTo);
                    });
            return this;
        }

        @Value
        public static class Edge {
            private String from;
            private String to;
        }
    }
}
