package it.unicam.cs.pa2021.formulaUno;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Classe che descrive una griglia come tipo di locazione per gli angoli di un Game Field.
 */
public final class GridLocation {

    private final int row;
    private final int column;

    public GridLocation(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Set<GridLocation> getAdjacentLocations(int width, int height) {
        return Stream.of(this.aboveLeft(width, height),
                this.above(width,height),
                this.aboveRight(width,height),
                this.right(width,height),
                this.belowRight(width,height),
                this.below(width,height),
                this.belowLeft(width,height),
                this.left(width,height))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    private Optional<GridLocation> left(int width, int height) { return adjacent(width,height,0,-1); }

    private Optional<GridLocation> belowLeft(int width, int height) {
    }

    private Optional<GridLocation> below(int width, int height) { return adjacent(width,height,-1,0); }

    private Optional<GridLocation> belowRight(int width, int height) {
    }

    private Optional<GridLocation> right(int width, int height) { return adjacent(width,height,0,+1); }

    private Optional<GridLocation> aboveRight(int width, int height) {
    }

    private Optional<GridLocation> above(int width, int height) { return adjacent(width,height,+1,0); }

    private Optional<GridLocation> aboveLeft(int width, int height) {
    }

    private Optional<GridLocation> adjacent(int width, int height, int dr, int dc) {
        int newR = row+dr;
        int newC = column+dc;
        if ((0<= newR)&&(newR<height)&&(0<=newC)&&(newC<width)) {
            return Optional.of(new GridLocation(newR,newC));
        } else {
            return Optional.empty();
        }
    }
}
