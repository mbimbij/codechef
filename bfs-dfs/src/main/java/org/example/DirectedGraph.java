package org.example;

import lombok.Value;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class DirectedGraph {
    public Map<String, Node> nodes;

    private DirectedGraph(Map<String, Node> nodes) {
        this.nodes = nodes;
    }

    public static DirectedGraph.Builder builder() {
        return new DirectedGraph.Builder();
    }

    public String[] bfsPath(String nodeIdFrom, String nodeIdTo) {
        ArrayList<String> nodesToVisit = new ArrayList<>();
        nodesToVisit.add(nodeIdFrom);

        return bfsPathInner(nodeIdFrom, nodeIdTo, nodesToVisit, new ArrayList<>()).toArray(new String[0]);
    }

    public List<String> bfsPathInner(String nodeIdFrom, String nodeIdTo, List<String> nodesToVisit, List<String> path) {
        path.add(nodeIdFrom);
        return path;
    }

    public boolean hasPathBFS(String nodeIdFrom, String nodeIdTo) {
        Queue<String> nodeIdsToVisit = new LinkedList<>();
        Set<String> visitedNodeIds = new HashSet<>();

        nodeIdsToVisit.add(nodeIdFrom);

        boolean pathExists = false;
        while (!nodeIdsToVisit.isEmpty()) {
            String currentNode = nodeIdsToVisit.poll();
            System.out.println("visiting node: " + currentNode);
            if (visitedNodeIds.contains(currentNode)) {
                System.out.println("skipping: " + currentNode);
            }
            if (Objects.equals(nodeIdTo, currentNode)) {
                pathExists = true;
                break;
            }
            visitedNodeIds.add(currentNode);
            nodes.get(currentNode)
                    .getAdjacentNodes()
                    .forEach(node -> nodeIdsToVisit.add(node.getNodeId()));
        }
        return pathExists;
    }

    public static class Builder {
        public Map<String, Node> nodes;

        public static Edge anEdge(String nodeIdFrom, String nodeIdTo) {
            return new Edge(nodeIdFrom, nodeIdTo);
        }

        public DirectedGraph build() {
            return new DirectedGraph(nodes);
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

    @Value
    public static class Node {
        String nodeId;
        List<Node> adjacentNodes;

        public Node(String nodeId) {
            this.nodeId = nodeId;
            adjacentNodes = new ArrayList<>();
        }

        public void addAdjacentNode(Node adjacentNode){
            adjacentNodes.add(adjacentNode);
        }
    }
}
