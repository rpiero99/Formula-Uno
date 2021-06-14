package it.unicam.cs.pa2021.formulaUno;

import java.util.Stack;

/**
 * Classe che implementa l'interfaccia Car e descrive un basico veicolo in un Game Field.
 */
public class SimpleCar implements Car<CornerStatus,GridLocation>{

    private final Player player;
    private final GameField field;
    private final Stack<GridLocation> locations;
    private boolean isInRace;

    /**
     * Creazione di un veicolo in una posizione di partenza
     * @param player giocatore che possiede il veicolo.
     * @param field campo in cui è collocato il veicolo.
     * @param startingLocation posizione di partenza del veicolo.
     */
    public SimpleCar(Player player, GameField field, GridLocation startingLocation) {
        this.player = player;
        this.field = field;
        this.locations = new Stack<>();
        this.locations.add(startingLocation);
        this.isInRace = true;
    }

    @Override
    public Player<CornerStatus, GridLocation> getPlayer() {
        return player;
    }

    @Override
    public GameField<CornerStatus, GridLocation> getField() {
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
