package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class UndirectedGraph {
    public Map<String, Node> nodes;

    private UndirectedGraph(Map<String, Node> nodes) {
        this.nodes = nodes;
    }

    public boolean hasPathBFS(String from, String to) {
        Set<String> visited = new HashSet<>();
        Queue<String> toVisit = new LinkedList<>();

        toVisit.add(from);
        while (!toVisit.isEmpty()) {
            String currentNode = toVisit.poll();
            visited.add(currentNode);
            if (Objects.equals(currentNode, to)) {
                return true;
            }
            Set<String> adjacentNodes = getAdjacentNodes(currentNode);
            adjacentNodes.stream()
                    .filter(adjacentNode -> !visited.contains(adjacentNode))
                    .forEach(toVisit::add);
        }
        return false;
    }

    public boolean hasPathDFS(String nodeIdFrom, String nodeIdTo) {
        return hasPathDFSInner(nodeIdFrom, nodeIdTo, new HashSet<>());
    }

    private boolean hasPathDFSInner(String currentNodeId, String nodeIdTo, Set<String> visitedNodes) {
        if(visitedNodes.contains(currentNodeId)){
            return false;
        }
        if (Objects.equals(currentNodeId, nodeIdTo)) {
            return true;
        }
        visitedNodes.add(currentNodeId);
        for (Node adjacentNode : nodes.get(currentNodeId).getAdjacentNodes()) {
            if (hasPathDFSInner(adjacentNode.id, nodeIdTo, visitedNodes)) {
                return true;
            }
        }

        return false;
    }

    public Set<String> getAdjacentNodes(String currentNode) {
        return nodes.get(currentNode).getAdjacentNodes().stream().map(Node::getId).collect(Collectors.toSet());
    }

    @RequiredArgsConstructor
    @Getter
    public static class Node {
        private final String id;
        Set<Node> adjacentNodes = new HashSet<>();

        public void addAdjacentNode(Node node) {
            adjacentNodes.add(node);
        }
    }

    public static Builder anUndirectedGraph() {
        return new Builder();
    }

    public static class Builder {
        public Map<String, Node> nodes;

        public Builder withNodes(String... nodeIds) {
            this.nodes = Arrays.stream(nodeIds)
                    .map(Node::new)
                    .collect(Collectors.toMap(
                            Node::getId,
                            identity()
                    ));
            return this;
        }

        public Builder withEdges(String[]... edges) {
            Arrays.stream(edges)
                    .forEach(nodeIds -> {
                        Node node1 = nodes.get(nodeIds[0]);
                        Node node2 = nodes.get(nodeIds[1]);
                        node1.addAdjacentNode(node2);
                        node2.addAdjacentNode(node1);
                    });
            return this;
        }

        public UndirectedGraph build() {
            return new UndirectedGraph(nodes);
        }
    }
}
