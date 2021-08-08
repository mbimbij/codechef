package org.example.nbpathmaze;

import lombok.Value;

import java.util.Arrays;
import java.util.Objects;

public class Maze {
    private final int nbRows;
    private final int nbCols;
    private final Obstacle[] obstacles;
    long[][] memo;

    public Maze(int nbRows, int nbCols) {
        this(nbRows, nbCols, new Obstacle[0]);
    }

    public Maze(int nbRows, int nbCols, Obstacle... obstacles) {
        this.nbRows = nbRows;
        this.nbCols = nbCols;
        memo = new long[this.nbRows][this.nbCols];
        Arrays.stream(memo).forEach(longs -> Arrays.fill(longs, -1L));
        this.obstacles = obstacles;
    }

    public long getNbPath(int rowStart, int colStart, int rowEnd, int colEnd) {
        if (isPositionInvalid(rowStart, colStart)) {
            return 0;
        }
        if (rowStart == rowEnd && colStart == colEnd) {
            return 1;
        }
        if (memo[rowStart][colStart] == -1) {
            memo[rowStart][colStart] = getNbPath(rowStart + 1, colStart, rowEnd, colEnd)
                    + getNbPath(rowStart, colStart + 1, rowEnd, colEnd);
        }
        return memo[rowStart][colStart];
    }

    private boolean isPositionInvalid(int rowStart, int colStart) {
        return positionIsOutOfBound(rowStart, colStart) || positionHitsAnObstacle(rowStart, colStart);
    }

    private boolean positionIsOutOfBound(int rowStart, int colStart) {
        return rowStart >= nbRows || colStart >= nbCols;
    }

    private boolean positionHitsAnObstacle(int rowStart, int colStart) {
        return Arrays.stream(obstacles)
                .anyMatch(obstacle -> obstacle.isHit(rowStart, colStart));
    }

    @Value
    public static class Obstacle {
        int row;
        int col;

        public boolean isHit(int row, int col){
            return Objects.equals(this.getRow(), row) && Objects.equals(this.getCol(), col);
        }
    }
}
