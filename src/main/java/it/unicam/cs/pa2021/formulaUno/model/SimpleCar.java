package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Stack;

/**
 * Classe che implementa l'interfaccia Car e descrive un basico veicolo in un Game Field.
 */
public class SimpleCar<L extends Location> implements Car<L>{

    private final Stack<L> locations;
    private boolean isInRace;

    /**
     * Creazione di un veicolo in una posizione di partenza
     * @param startingLocation posizione di partenza del veicolo.
     */
    public SimpleCar(L startingLocation) {
        this.locations = new Stack<>();
        this.locations.add(startingLocation);
        this.isInRace = true;
    }

    @Override
    public L getCurrentLocation() {
        if(this.locations.isEmpty())
            throw new IllegalArgumentException("Nessuna posizione registrata per il veicolo.");
        return this.locations.lastElement();
    }

    @Override
    public L getPreviousLocation() {
        if(this.locations.isEmpty() || this.locations.size()==1)
            return getCurrentLocation();
        return this.locations.elementAt(locations.size()-2);
    }

    @Override
    public void moveToNewLocation(L location) {
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

}
