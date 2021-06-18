package it.unicam.cs.pa2021.formulaUno.model;

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
     * Imposta il game field in cui gioca il giocatore.
     * @param field il game field in cui gioca il giocatore.
     */
    void setField(GameField<L> field);

    /**
     * Restituisce il game field in cui gioca il giocatore.
     * @return il game field in cui gioca il giocatore.
     */
    GameField<L> getField();

    /**
     * Restituisce il veicolo associato al giocatore.
     * @return il veicolo associato al giocatore.
     */
    Car<L> getCar();

    /**
     * Sposta il veicolo in una delle posizioni passate come parametro.
     * @param possibleLocations posizioni candidate per essere attraversate dal veicolo.
     * @return il movimento che il giocatore vuole fare.
     */
    Move<L> moveCarTo(Set<L> possibleLocations);
}
