package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Objects;
import java.util.Set;

/**
 * Classe che implementa un giocatore bot.
 */
public class BotPlayer implements Player<GridLocation> {

    //TODO: implementa un modo per scegliere automaticamente le posizioni in cui spostare il veicolo.
    private final String name;
    private final GameField<GridLocation> field;

    /**
     * Construttore per un giocatore bot.
     * @param name nome del giocatore.
     * @param field campo nel quale opera il giocatore.
     */
    public BotPlayer(String name, GameField<GridLocation> field) {
        this.name = name;
        this.field = field;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public GameField <GridLocation> getField() {
        return this.field;
    }

    @Override
    public Car<GridLocation> getCar() {
        return null;
    }

    @Override
    public Move<GridLocation> moveCarTo(Set<GridLocation> possibleLocations) {
        return null;
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
