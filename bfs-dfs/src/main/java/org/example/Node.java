package org.example;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Node {
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
