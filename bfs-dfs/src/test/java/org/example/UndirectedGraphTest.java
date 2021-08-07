package org.example;

import org.assertj.core.api.SoftAssertions;
import org.example.UndirectedGraph.Edge;
import org.junit.jupiter.api.Test;

import static org.example.UndirectedGraph.anUndirectedGraph;

class UndirectedGraphTest {

    @Test
    void canCreateAnUndirectedGraph() {
        UndirectedGraph graph = anUndirectedGraph()
                .withNodes("graphbdfsmote".split(""))
                .withEdges(
                        new Edge("g", "r"),
                        new Edge("r", "g"),
                        new Edge("r", "a")
                ).build();

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(graph.getNumberOfEdges()).isEqualTo(2);
            softAssertions.assertThat(graph.getNumberOfNodes()).isEqualTo(13);
        });
    }
}