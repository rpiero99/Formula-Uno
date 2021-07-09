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
     * Sposta il veicolo in una delle posizioni passate come parametro.
     * @param possibleLocations posizioni candidate per essere attraversate dal veicolo.
     * @return il movimento che il giocatore vuole fare.
     */
    Move<L> moveCarTo(Set<L> possibleLocations);
}
