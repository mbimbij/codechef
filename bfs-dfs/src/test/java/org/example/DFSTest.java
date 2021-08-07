package org.example;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.DirectedGraph.Builder.anEdge;

public class DFSTest {

    @Test
    void canCreateGraph() {
        DirectedGraph directedGraph = DirectedGraph.builder()
                .withNodes("g", "r", "a", "p", "h", "b", "f", "d", "s")
                .withEdges(
                        anEdge("g", "r"),
                        anEdge("r", "a")
                )
                .build();
        System.out.println();
    }

    @Test
    @Disabled
    void name() {
        // GIVEN
        DirectedGraph directedGraph = DirectedGraph.builder()
                .withNodes("g", "r")
                .withEdges(
                        anEdge("g", "r")
                )
                .build();
        String[] expectedDfsPath = {"g", "r"};

        // WHEN
        String[] dfsPath = directedGraph.bfsPath("g", "r");

        // THEN
        assertThat(dfsPath).isEqualTo(expectedDfsPath);
    }

    @Test
    void hasPathDfsTest() {
        // GIVEN
        DirectedGraph directedGraph = getGraph();

        // WHEN / THEN
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(directedGraph.hasPathBFS("g","h")).isTrue();
            softAssertions.assertThat(directedGraph.hasPathBFS("m","e")).isTrue();
            softAssertions.assertThat(directedGraph.hasPathBFS("g","m")).isFalse();
        });
    }

    private DirectedGraph getGraph() {
        DirectedGraph directedGraph = DirectedGraph.builder()
                .withNodes("g", "r", "a", "p", "h", "b", "f", "d", "s", "m", "o", "r2", "e")
                .withEdges(
                        anEdge("g", "r"),
                        anEdge("r", "a"),
                        anEdge("a", "p"),
                        anEdge("a", "s"),
                        anEdge("p", "h"),
                        anEdge("s", "h"),
                        anEdge("g", "b"),
                        anEdge("b", "d"),
                        anEdge("b", "f"),
                        anEdge("d", "f"),
                        anEdge("f", "s"),

                        anEdge("m", "o"),
                        anEdge("m", "r2"),
                        anEdge("r2", "o"),
                        anEdge("o", "e")
                        )
                .build();
        return directedGraph;
    }
}
