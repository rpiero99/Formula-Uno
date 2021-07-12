package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Objects;

/**
 * Classe che implementa un giocatore interattivo, ossia guidato dall'utente.
 * @param <L> tipo per la posizione di un angolo
 */
public class InteractivePlayer<L extends Location> implements Player<L>{

    private boolean isWinner;
    private Car<L> car;
    private final String name;
    private final GameField<L> field;

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
    public Move<L> moveCarTo(L nextLocation) {
        return new SimpleMove<>(getCar(), nextLocation);
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
