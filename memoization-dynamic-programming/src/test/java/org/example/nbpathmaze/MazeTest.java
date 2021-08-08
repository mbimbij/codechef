package org.example.nbpathmaze;

import org.example.nbpathmaze.Maze.Obstacle;
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

    @Test
    void given8_8MazeFromDemo_shouldComputePathLengthCorrectly() {
        Maze maze = spy(
                new Maze(8, 8,
                        new Obstacle(1,2),
                        new Obstacle(1,6),
                        new Obstacle(2,4),
                        new Obstacle(3,0),
                        new Obstacle(3,2),
                        new Obstacle(3,5),
                        new Obstacle(4,2),
                        new Obstacle(3,5),
                        new Obstacle(5,3),
                        new Obstacle(5,4),
                        new Obstacle(5,6),
                        new Obstacle(6,1),
                        new Obstacle(6,5)
                ));
        maze.getNbPath(0,0,7,7);
        verify(maze, Mockito.atMost(2)).getNbPath(1, 1, 2, 2);
        verify(maze, Mockito.atMost(2)).getNbPath(1, 2, 2, 2);
        verify(maze, Mockito.atMost(2)).getNbPath(2, 1, 2, 2);
        verify(maze, Mockito.atMost(2)).getNbPath(2, 2, 2, 2);
        verify(maze, Mockito.atMostOnce()).getNbPath(2, 2, 2, 2);
    }
}