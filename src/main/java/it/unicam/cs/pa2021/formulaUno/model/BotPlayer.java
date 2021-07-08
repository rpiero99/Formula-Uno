package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * Classe che implementa un giocatore bot.
 */
public class BotPlayer<L extends Location> implements Player<L> {

    private boolean isWinner;
    private final String name;
    private final Car<L> car;
    
    /**
     * Construttore per un giocatore bot.
     * @param name nome del giocatore.
     * @param initialPosition posizione di partenza del veicolo.
     */
    public BotPlayer(String name, L initialPosition) {
        this.name = name;
        this.car = new SimpleCar<>(initialPosition);
        this.isWinner = false;
    }

    @Override
    public String getName() {
        return this.name;
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
    public Move<L> moveCarTo(Set<L> possibleLocations) {
        Random random = new Random();
        L choice = possibleLocations.stream().skip(random.nextInt(possibleLocations.size())).findFirst().get();
        return new SimpleMove<>(getCar(), choice);
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
