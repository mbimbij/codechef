package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.Graph.Builder.anEdge;

public class DFSTest {

    @Test
    void canCreateGraph() {
        Graph graph = Graph.builder()
                .withNodes("g","r","a","p","h","b","f","d","s")
                .withEdges(
                        anEdge("g","r"),
                        anEdge("r","a")
                )
                .build();
        System.out.println();
    }

    @Test
    void name() {
        // GIVEN
        Graph graph = Graph.builder()
                .withNodes("g")
                .build();
        String[] expectedDfsPath = {"g"};

                // WHEN
        String[] dfsPath = graph.dfsPath("g","g");

        // THEN
        assertThat(dfsPath).isEqualTo(expectedDfsPath);
    }
}
