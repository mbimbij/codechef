package org.example.nbpathmaze;

import java.util.Arrays;

public class Maze {
    private final int nbRows;
    private final int nbCols;
    long[][] memo;


    public Maze(int nbRows, int nbCols) {
        this.nbRows = nbRows;
        this.nbCols = nbCols;
        memo = new long[this.nbRows][this.nbCols];
        Arrays.stream(memo).forEach(longs -> Arrays.fill(longs, -1L));
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
        return rowStart >= nbRows || colStart >= nbCols;
    }
}
