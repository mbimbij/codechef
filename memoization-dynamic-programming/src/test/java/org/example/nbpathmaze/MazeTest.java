package org.example.nbpathmaze;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MazeTest {
    @Test
    void canCreateMaze() {
        Maze maze = new Maze(1, 1);
    }

    @Test
    void givenMaze1Row1Col_whenComputeNbPath_thenResultIs1() {
        // GIVEN
        Maze maze = new Maze(1, 1);

        // WHEN / THEN
        long nbPath = maze.getNbPath(0, 0, 0, 1);
        assertThat(nbPath).isEqualTo(1L);
    }
}