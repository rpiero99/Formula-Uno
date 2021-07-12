package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Objects;

/**
 * Classe che implementa un giocatore bot.
 */
public class BotPlayer<L extends Location> implements Player<L> {

    private boolean isWinner;
    private final String name;
    private final GameField<L> field;
    private Car<L> car;
    
    /**
     * Construttore per un giocatore bot.
     * @param name nome del giocatore.
     * @param field
     */
    public BotPlayer(String name, GameField<L> field) {
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
        return this.field;
    }

    @Override
    public Car<L> createNewCar(L initialLocation) {
        this.car = new SimpleCar<>(initialLocation);
        return getCar();
    }

    @Override
    public Car<L> getCar() {
        return this.car;
    }

    @Override
    public boolean isWinner() {
        return this.isWinner;
    }

    @Override
    public void setWinner(boolean winner) {
        this.isWinner = winner;
    }

    @Override
    public Move<L> moveCarTo(L nextLocation) {
        return new SimpleMove<>(getCar(), nextLocation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotPlayer botPlayer = (BotPlayer) o;
        return name.equals(botPlayer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
