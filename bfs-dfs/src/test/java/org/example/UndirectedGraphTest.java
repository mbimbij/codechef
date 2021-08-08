package org.example;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.UndirectedGraph.anUndirectedGraph;

class UndirectedGraphTest {

    private UndirectedGraph graph;

    @BeforeEach
    void setUp() {
        graph = anUndirectedGraph()
                .withNodes("graphbdfsmote".split(""))
                .withEdges(
                        new String[]{"g", "r"},
                        new String[]{"r", "g"},
                        new String[]{"r", "a"},
                        new String[]{"a", "p"},
                        new String[]{"a", "s"},
                        new String[]{"p", "h"},
                        new String[]{"s", "h"},
                        new String[]{"g", "b"},
                        new String[]{"b", "d"},
                        new String[]{"b", "f"},
                        new String[]{"d", "f"},
                        new String[]{"f", "s"}
                ).build();
    }

    @Test
    void hasPathBFS() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(graph.hasPathBFS("g","g")).isTrue();
            softAssertions.assertThat(graph.hasPathBFS("g","r")).isTrue();
            softAssertions.assertThat(graph.hasPathBFS("g","h")).isTrue();
            softAssertions.assertThat(graph.hasPathBFS("g","t")).isFalse();
        });
    }

    @Test
    void hasPathDFS() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(graph.hasPathDFS("g","g")).isTrue();
            softAssertions.assertThat(graph.hasPathDFS("g","r")).isTrue();
            softAssertions.assertThat(graph.hasPathDFS("g","h")).isTrue();
            softAssertions.assertThat(graph.hasPathDFS("g","t")).isFalse();
        });
    }
}