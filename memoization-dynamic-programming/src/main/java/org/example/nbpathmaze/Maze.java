package org.example.nbpathmaze;

public class Maze {
    private final int nbRows;
    private final int nbCols;

    public Maze(int nbRows, int nbCols) {
        this.nbRows = nbRows;
        this.nbCols = nbCols;
    }

    public long getNbPath(int rowStart, int colStart, int rowEnd, int colEnd) {
        return 1;
    }
}
