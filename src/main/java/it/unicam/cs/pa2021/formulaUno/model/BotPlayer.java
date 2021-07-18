package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

/**
 * Classe che implementa un giocatore bot, non controllato quindi da un utente.
 */
public class BotPlayer<L extends Location> implements Player<L> {

    private boolean isWinner;
    private final String name;
    private final GameField<L> field;
    private Car<L> car;

    /**
     * Construttore per un giocatore bot.
     *
     * @param name  nome del giocatore.
     * @param field game field nel quale gioca il giocatore.
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

    /**
     * Metodo che sceglie attraverso una funzione random la prossima posizione da occupare per il veicolo.
     * @return la prossima posizione del veicolo.
     */
    private L randomChoice() {
        Random random = new Random();
        return getNextPossibleMoves().stream().skip(random.nextInt(getNextPossibleMoves().size())).findFirst().get();
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
    public Set<L> getNextPossibleMoves() {
        return (Set<L>) this.getCar().getCurrentLocation().nextPossibleLocations(getCar(),getGameField());
    }

    @Override
    public Move<L> moveCarTo(Optional<L> nextLocation) {
        return nextLocation.<Move<L>>map(l -> new SimpleMove<>(getCar(), l)).orElseGet(() -> new SimpleMove<>(getCar(), randomChoice()));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotPlayer<?> botPlayer = (BotPlayer<?>) o;
        return name.equals(botPlayer.name) && field.equals(botPlayer.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, field);
    }
}
