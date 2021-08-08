package org.example.nbpathmaze;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class MazeTest {
    @ParameterizedTest
    @CsvSource({
            "1 , 1, 0, 0, 0, 0, 1",
            "2 , 2, 1, 0, 1, 1, 1",
            "2 , 2, 0, 1, 1, 1, 1",
            "2 , 2, 0, 0, 1, 1, 2",
    })
    void givenMaze_whenComputeNbPathFromStartToEnd_thenResultIsAsExpected(int nbRows,
                                                                          int nbCols,
                                                                          int rowStart,
                                                                          int colStart,
                                                                          int rowEnd,
                                                                          int colEnd,
                                                                          long expectedNbPath) {
        // GIVEN
        Maze maze = new Maze(nbRows, nbCols);

        // WHEN / THEN
        long nbPath = maze.getNbPath(rowStart, colStart, rowEnd, colEnd);
        assertThat(nbPath).isEqualTo(expectedNbPath);
    }

    @Test
    void given3_3Maze_thenNoPositionHasBeenComputedMoreThanOnce() {
        Maze maze = spy(new Maze(3, 3));
        maze.getNbPath(0,0,2,2);
        verify(maze, Mockito.atLeastOnce()).getNbPath(1, 1, 2, 2);
        verify(maze, Mockito.atMost(2)).getNbPath(1, 1, 2, 2);

        verify(maze, Mockito.atLeastOnce()).getNbPath(1, 2, 2, 2);
        verify(maze, Mockito.atMost(2)).getNbPath(1, 2, 2, 2);

        verify(maze, Mockito.atLeastOnce()).getNbPath(2, 1, 2, 2);
        verify(maze, Mockito.atMost(2)).getNbPath(2, 1, 2, 2);

        verify(maze, Mockito.atLeastOnce()).getNbPath(2, 2, 2, 2);
        verify(maze, Mockito.atMost(2)).getNbPath(2, 2, 2, 2);
    }

//    @Test
//    void given3_3Maze_thenNoPositionHasBeenComputedMoreThanOnce() {
//        Maze maze = spy(new Maze(3, 3));
//        verify(maze, Mockito.atMost(2)).getNbPath(1, 1, 2, 2);
//        verify(maze, Mockito.atMost(2)).getNbPath(1, 2, 2, 2);
//        verify(maze, Mockito.atMost(2)).getNbPath(2, 1, 2, 2);
//        verify(maze, Mockito.atMost(2)).getNbPath(2, 2, 2, 2);
//        verify(maze, Mockito.atMostOnce()).getNbPath(2, 2, 2, 2);
//    }
}