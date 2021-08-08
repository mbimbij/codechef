package org.example.nbpathmaze;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MazeTest {
    @ParameterizedTest
    @CsvSource({
            "1 , 1, 0, 0, 0, 0, 1",
            "2 , 2, 1, 0, 1, 1, 1",
            "2 , 2, 0, 1, 1, 1, 1",
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
}