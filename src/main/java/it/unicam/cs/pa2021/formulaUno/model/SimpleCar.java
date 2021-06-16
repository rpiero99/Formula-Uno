package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Stack;

/**
 * Classe che implementa l'interfaccia Car e descrive un basico veicolo in un Game Field.
 */
public class SimpleCar implements Car<GridLocation>{

    private final Player<GridLocation> player;
    private final GameField<GridLocation> field;
    private final Stack<GridLocation> locations;
    private boolean isInRace;

    /**
     * Creazione di un veicolo in una posizione di partenza
     * @param player giocatore che possiede il veicolo.
     * @param field campo in cui è collocato il veicolo.
     * @param startingLocation posizione di partenza del veicolo.
     */
    public SimpleCar(Player<GridLocation> player, GameField<GridLocation> field, GridLocation startingLocation) {
        this.player = player;
        this.field = field;
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
        return field;
    }

    @Override
    public GridLocation getCurrentLocation() {
        if(this.locations.isEmpty())
            throw new IllegalArgumentException("Nessuna posizione registrata per il veicolo.");
        return this.locations.lastElement();
    }

    @Override
    public GridLocation getPreviousLocation() {
        if(this.locations.isEmpty())
            throw new IllegalArgumentException("Nessuna posizione registrata per il veicolo.");
        if(this.locations.size()==1)
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
    public boolean isInRace() {
        return this.isInRace;
    }

}
