package it.unicam.cs.pa2021.formulaUno;

import java.util.Set;

/**
 * Interfaccia che definisce un giocatore di Formula Uno.
 * @param <S> tipo di stato di un angolo
 * @param <L> tipo per la posizione di un angolo
 */
public interface Player<S,L> {

    /**
     * Restituisce il nome del giocatore.
     * @return il nome del giocatore.
     */
    String getName();

    /**
     * Restituisce il campo da gioco in cui gioca il giocatore.
     * @return il campo da gioco in cui gioca il giocatore.
     */
    GameField<S,L> getField();

    /**
     * Sposta il veicolo in una delle posizioni passate come parametro.
     * @param possibleLocations posizioni candidate per essere attraversate dal veicolo.
     * @return la posizione scelta per lo spostamento.
     */
    L moveCarTo(Set<L> possibleLocations);
}
