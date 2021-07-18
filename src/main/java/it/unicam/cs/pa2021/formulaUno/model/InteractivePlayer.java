package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * Classe che implementa un giocatore interattivo, ossia guidato dall'utente. Ad un utente interattivo deve essere sempre passata
 * una nuova posizione per la macchina (non ha la funzione random che ha un bot player).
 * @param <L> tipo per la posizione di un angolo.
 */
public class InteractivePlayer<L extends Location> implements Player<L>{

    private boolean isWinner;
    private Car<L> car;
    private final String name;
    private final GameField<L> field;

    /**
     * Costruttore per un giocatore interattivo.
     * @param name nome del giocatore.
     * @param field game field nel quale gioca il giocatore.
     */
    public InteractivePlayer(String name, GameField<L> field) {
        this.name = name;
        this.field = field;
        this.isWinner = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public GameField<L> getGameField() {
        return field;
    }

    @Override
    public Car<L> createNewCar(L initialLocation) {
        this.car = new SimpleCar<>(initialLocation);
        return car;
    }

    @Override
    public Car<L> getCar() {
        return this.car;
    }

    @Override
    public boolean isWinner() {
        return isWinner;
    }

    @Override
    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    @Override
    public Set<L> getNextPossibleMoves() {
        return (Set<L>) this.getCar().getCurrentLocation().nextPossibleLocations(getCar(),getGameField());
    }

    @Override
    public Move<L> moveCarTo(Optional<L> nextLocation) {
        if (nextLocation.isPresent())
            return new SimpleMove<>(getCar(), nextLocation.get());
        else
            throw new NullPointerException("Non puoi passare una posizione nulla");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InteractivePlayer<?> that = (InteractivePlayer<?>) o;
        return name.equals(that.name) && field.equals(that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, field);
    }
}
