package org.example.nbpathmaze;

public class Maze {
    private final int nbRows;
    private final int nbCols;

    public Maze(int nbRows, int nbCols) {
        this.nbRows = nbRows;
        this.nbCols = nbCols;
    }

    public long getNbPath(int rowStart, int colStart, int rowEnd, int colEnd) {
        if(isPositionInvalid(rowStart, colStart)){
            return 0;
        }
        if (rowStart == rowEnd && colStart == colEnd) {
            return 1;
        } else return getNbPath(rowStart + 1, colStart, rowEnd, colEnd)
                + getNbPath(rowStart, colStart + 1, rowEnd, colEnd);
    }

    private boolean isPositionInvalid(int rowStart, int colStart) {
        return rowStart >= nbRows || colStart >= nbCols;
    }
}
