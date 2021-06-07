package it.unicam.cs.pa2021.formulaUno;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Classe che descrive una griglia come tipo di locazione per gli angoli di un Game Field.
 */
public class GridLocation{

    private final int column;
    private final int row;

    public GridLocation(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    /**
     * Dato un veicolo, restituisce l'insieme delle posizioni che potrà avere il veicolo.
     * @param car il veicolo di cui dobbiamo calcolare l'insieme delle posizioni successive.
     * @return restituisce l'insieme delle posizioni che potrà avere il veicolo.
     */
    public Set<GridLocation> nextPossibleLocations(Car car) {
        if (!this.equals(car.getCurrentLocation()))
            throw new IllegalArgumentException("ERRORE!: la posizione che ha chiamato questo metodo non è la stessa posizione del veicolo");

        return null;
    }

    /**
     * Restituisce l'insieme delle locazioni adiacenti a questa locazione.
     * @param width larghezza del GameField.
     * @param height altezza del GameField.
     * @return l'insieme delle locazioni adiacenti a questa locazione.
     */
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

    /**
     * Restituisce la locazione a sinistra, se c'&egrave;.
     * @param width larghezza del GameField.
     * @param height altezza del GameField.
     * @return la locazione a sinistra, se c'&egrave;.
     */
    private Optional<GridLocation> left(int width, int height) { return adjacent(width,height,-1,0); }

    /**
     * Restituisce la locazione in basso a sinistra, se c'&egrave;.
     * @param width larghezza del GameField.
     * @param height altezza del GameField.
     * @return la locazione in basso a sinistra, se c'&egrave;.
     */
    private Optional<GridLocation> belowLeft(int width, int height) { return adjacent(width, height,-1, -1);}

    /**
     * Restituisce la locazione in basso al centro, se c'&egrave;.
     * @param width larghezza del GameField.
     * @param height altezza del GameField.
     * @return la locazione in basso al centro, se c'&egrave;.
     */
    private Optional<GridLocation> below(int width, int height) { return adjacent(width,height,0,-1); }

    /**
     * Restituisce la locazione in basso a destra, se c'&egrave;.
     * @param width larghezza del GameField.
     * @param height altezza del GameField.
     * @return la locazione in basso a destra, se c'&egrave;.
     */
    private Optional<GridLocation> belowRight(int width, int height) { return adjacent(width,height,+1, -1);}

    /**
     * Restituisce la locazione a destra, se c'&egrave;.
     * @param width larghezza del GameField.
     * @param height altezza del GameField.
     * @return la locazione a destra, se c'&egrave;.
     */
    private Optional<GridLocation> right(int width, int height) { return adjacent(width,height,+1,0); }

    /**
     * Restituisce la locazione in alto a destra, se c'&egrave;.
     * @param width larghezza del GameField.
     * @param height altezza del GameField.
     * @return la locazione in alto a destra, se c'&egrave;.
     */
    private Optional<GridLocation> aboveRight(int width, int height) { return adjacent(width, height, +1, +1);}

    /**
     * Restituisce la locazione in alto al centro, se c'&egrave;.
     * @param width larghezza del GameField.
     * @param height altezza del GameField.
     * @return la locazione in alto al centro, se c'&egrave;.
     */
    private Optional<GridLocation> above(int width, int height) { return adjacent(width,height,0,+1); }

    /**
     * Restituisce la locazione in alto a sinistra, se c'&egrave;.
     * @param width larghezza del GameField.
     * @param height altezza del GameField.
     * @return la locazione in alto a sinistra, se c'&egrave;.
     */
    private Optional<GridLocation> aboveLeft(int width, int height) { return adjacent(width,height,-1,+1);}

    /**
     *
     * @param width larghezza del GameField.
     * @param height altezza del GameField.
     * @param diffColumn differenza tra la colonna della locazione con quella della locazione richiesta.
     * @param diffRow differenza tra la riga della locazione con quella della locazione richiesta.
     * @return la locazione richiesta, se c'&egrave;
     */
    private Optional<GridLocation> adjacent(int width, int height, int diffColumn, int diffRow) {
        int newCol = column +diffColumn;
        int newRow = row +diffRow;
        if ((0<= newCol)&&(newCol<=width)&&(0<=newRow)&&(newRow<=height)) {
            return Optional.of(new GridLocation(newCol,newRow));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridLocation that = (GridLocation) o;
        return column == that.column && row == that.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }
}
