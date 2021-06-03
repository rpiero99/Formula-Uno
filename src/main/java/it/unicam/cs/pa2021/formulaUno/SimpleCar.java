package it.unicam.cs.pa2021.formulaUno;

/**
 * Classe che implementa l'interfaccia Car e descrive un basico veicolo in un Game Field.
 */
public class SimpleCar implements Car<CornerStatus,GridLocation>{

    private final Player player;
    private final GameField field;
    private GridLocation prevLocation;
    private GridLocation currLocation;
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
        this.currLocation = startingLocation;
        this.prevLocation = null;
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
        return this.currLocation;
    }

    @Override
    public GridLocation getPreviousLocation() {
        return this.prevLocation;
    }

    @Override
    public void moveToNewLocation(GridLocation location) {
        this.prevLocation=currLocation;
        this.currLocation=location;
    }

    @Override
    public boolean isInRace() {
        return this.isInRace;
    }

}
