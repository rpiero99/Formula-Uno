package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Optional;
import java.util.Set;

/**
 * Interfaccia che definisce un giocatore di Formula Uno.
 * @param <L> tipo per la posizione di un angolo
 */
public interface Player<L extends Location> {

    /**
     * Restituisce il nome del giocatore.
     * @return il nome del giocatore.
     */
    String getName();

    /**
     * Restituisce il game field in cui si trova il giocatore.
     * @return il game field in cui si trova il giocatore.
     */
    GameField<L> getGameField();

    /**
     * Crea e restituisce il nuovo veicolo associato al giocatore.
     * @param initialLocation posizione iniziale del veicolo.
     * @return il nuovo veicolo creato.
     */
    Car<L> createNewCar(L initialLocation);

    /**
     * Restituisce il veicolo associato al giocatore.
     * @return il veicolo associato al giocatore.
     */
    Car<L> getCar();

    /**
     * Restituisce true se il giocatore ha vinto questa gara, false altrimenti.
     * @return true se il giocatore ha vinto questa gara, false altrimenti.
     */
    boolean isWinner();

    /**
     * Imposta true se il giocatore ha vinto, false altrimenti.
     * @param winner esito della gara.
     */
    void setWinner(boolean winner);

    /**
     * Restituisce l'insieme di posizioni in cui il veicolo potr&agrave; spostarsi.
     * @return l'insieme di posizioni in cui il veicolo potr&agrave; spostarsi.
     */
    Set<L> getNextPossibleMoves();

    /**
     * Sposta il veicolo in una delle posizioni passate come parametro.
     * @param nextLocation prossima posizione scelta per il veicolo.
     * @return il movimento che il giocatore vuole fare.
     */
    Move<L> moveCarTo(Optional<L> nextLocation);


}
