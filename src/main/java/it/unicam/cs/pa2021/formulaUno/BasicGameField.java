package it.unicam.cs.pa2021.formulaUno;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Classe che implementa l'interfaccia GameField; descrive un classico campo formato da una griglia.
 */
public class BasicGameField implements GameField<CornerStatus, GridLocation>{

    private final Corner<CornerStatus, GridLocation> [][] cornerGrid;
    private final int width;
    private final int height;

    /**
     * Crea un campo con le dimensioni date, in cui tutti gli angoli sono in uno stato di OUT_OF_RACE.
     * @param width larghezza del campo.
     * @param height altezza del campo.
     */
    public BasicGameField(int width, int height) {
        this.width = width;
        this.height = height;
        this.cornerGrid= new Corner[height][width];
        for(int row=0; row<height;row++){
            for(int col=0; col<width; col++)
                this.cornerGrid[row][col] = new BasicCorner<>(this, CornerStatus.OUT_OF_RACE,new GridLocation(row,col));
        }
    }

    @Override
    public Corner<CornerStatus,GridLocation> getCornerAt(GridLocation location) {
        return this.cornerGrid[location.getRow()][location.getColumn()];
    }

    @Override
    public Set<Corner<CornerStatus,GridLocation>> getAdjacentCorners(GridLocation location) {
        return this.getCorners(location.getAdjacentLocations(width,height));
    }

    private Set<Corner<CornerStatus, GridLocation>> getCorners(Set<GridLocation> adjacentLocations) {
        return adjacentLocations.stream()
                .map(this::getCornerAt)
                .collect(Collectors.toSet());
    }

    private Set<GridLocation> getAdjacentLocations(GridLocation location) {
        return location.getAdjacentLocations(width,height);
    }

    @Override
    public GameField<CornerStatus,GridLocation> nextMove(Move moves) {
        return null;
    }
}
