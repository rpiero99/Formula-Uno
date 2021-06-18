package it.unicam.cs.pa2021.formulaUno.model;

/**
 * Classe che implementa un movimento generico di un veicolo.
 * @param <L> tipo per la posizione di un angolo.
 */
public class SimpleMove <L extends Location> implements Move<L>{

    private final L newLocation;
    private final Car<L> car;

    /**
     * Construttore per un movimento basico di un veicolo.
     * @param car veicolo da spostare.
     * @param newLocation nuova posizione del veicolo.
     */
    public SimpleMove (Car<L> car, L newLocation){
        this.car= car;
        this.newLocation = newLocation;
    }

    @Override
    public void apply() {
        car.moveToNewLocation(newLocation);
    }
}
