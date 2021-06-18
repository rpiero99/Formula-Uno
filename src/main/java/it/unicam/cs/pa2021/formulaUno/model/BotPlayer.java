package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * Classe che implementa un giocatore bot.
 */
public class BotPlayer implements Player<GridLocation> {

    //TODO: implementa un modo per scegliere automaticamente le posizioni in cui spostare il veicolo.
    private final String name;
    private GameField<GridLocation> field;
    private final Car<GridLocation> car;


    /**
     * Construttore per un giocatore bot.
     * @param name nome del giocatore.
     * @param initialPosition posizione di partenza del veicolo.
     */
    public BotPlayer(String name, GridLocation initialPosition) {
        this.name = name;
        this.field = null;
        this.car = new SimpleCar(this, initialPosition);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setField(GameField<GridLocation> field){
        this.field = field;
    }

    @Override
    public GameField <GridLocation> getField() {
        return this.field;
    }

    @Override
    public Car<GridLocation> getCar() {
        return this.car;
    }

    @Override
    public Move<GridLocation> moveCarTo(Set<GridLocation> possibleLocations) {
        Random random = new Random();
        GridLocation choice = possibleLocations.stream().skip(random.nextInt(possibleLocations.size())).findFirst().get();
        return new SimpleMove<>(getCar(), choice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotPlayer botPlayer = (BotPlayer) o;
        return name.equals(botPlayer.name) && field.equals(botPlayer.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, field);
    }
}
