package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Set;

/**
 * Interfaccia che definisce un campo da gioco di formula uno.
 * @param <L> tipo per la posizione di un angolo
 */
public interface GameField<L extends Location> {

    /**
     * Restituisce la larghezza del GameField.
     * @return la larghezza del GameField.
     */
    int getWidth();

    /**
     * Restituisce l'altezza del GameField.
     * @return l'altezza del GameField.
     */
    int getHeight();

    /**
     * Restituisce un angolo ad una certa locazione.
     * @param location posizione nel campo da gioco.
     * @return l'angolo alla posizione data.
     */
    Corner<L> getCornerAt(L location);

    /**
     * Restituisce tutti i giocatori partecipanti al gioco.
     * @return l'insieme dei giocatori.
     */
    Set<Player<L>> getPlayers();

    /**
     * Restituisce l'insieme di posizioni in cui il veicolo potr&agrave; spostarsi.
     * @param car il veicolo di cui si vuole conoscere le prossime posizioni.
     * @return l'insieme di posizioni in cui il veicolo potr&agrave; spostarsi.
     */
    Set<L> getNextPossibleMoves (Car<L> car);

    /**
     * Applica al campo da gioco le mosse fatte dai giocatori.
     * @param moves le mosse dei giocatori.
     * @return il nuovo campo con l'applicazione delle mosse.
     */
    GameField<L> nextStage(Set<Move<L>> moves);

}
