package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Objects;

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
        if(car.isInRace())
            car.moveToNewLocation(newLocation);
        else
            throw new IllegalStateException("Il veicolo non è attualmente in corsa, aspetta la prossima gara");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleMove<?> that = (SimpleMove<?>) o;
        return car.equals(that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car);
    }
}
