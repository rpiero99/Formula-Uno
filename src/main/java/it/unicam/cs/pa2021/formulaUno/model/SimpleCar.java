package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Objects;
import java.util.Stack;

/**
 * Classe che implementa l'interfaccia Car e descrive un basico veicolo in un Game Field.
 */
public class SimpleCar implements Car<GridLocation>{

    private final Player<GridLocation> player;
    private final Stack<GridLocation> locations;
    private boolean isInRace;

    /**
     * Creazione di un veicolo in una posizione di partenza
     * @param player giocatore che possiede il veicolo.
     * @param startingLocation posizione di partenza del veicolo.
     */
    public SimpleCar(Player<GridLocation> player, GridLocation startingLocation) {
        this.player = player;
        this.locations = new Stack<>();
        this.locations.add(startingLocation);
        this.isInRace = true;
    }

    @Override
    public Player<GridLocation> getPlayer() {
        return player;
    }

    @Override
    public GameField<GridLocation> getField() {
        return getPlayer().getField();
    }

    @Override
    public GridLocation getCurrentLocation() {
        if(this.locations.isEmpty())
            throw new IllegalArgumentException("Nessuna posizione registrata per il veicolo.");
        return this.locations.lastElement();
    }

    @Override
    public GridLocation getPreviousLocation() {
        if(this.locations.isEmpty() || this.locations.size()==1)
            return getCurrentLocation();
        return this.locations.elementAt(locations.size()-2);
    }

    @Override
    public void moveToNewLocation(GridLocation location) {
        this.locations.add(location);
    }

    @Override
    public void clearLocations() {
        this.locations.clear();
    }

    @Override
    public void changeStatus(boolean status) {
        isInRace=status;
    }

    @Override
    public boolean isInRace() {
        return this.isInRace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleCar simpleCar = (SimpleCar) o;
        return player.equals(simpleCar.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }

}
