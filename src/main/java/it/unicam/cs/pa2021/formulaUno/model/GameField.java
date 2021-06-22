package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Set;
import java.util.function.Predicate;

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
     * Restituisce un angolo ad una certa locazione, restituendo un'eccezione se la locazione passata non &egrave; compresa nel game field.
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
     * Restituisce tutti i veicoli appartenenti a questo game field.
     * @return i veicoli appartenenti a questo game field.
     */
    Set<Car<GridLocation>> getCars();

    /**
     * Restituisce tutti i veicoli che soddisfano un dato predicato.
     * @param predicate predicato per scegliere i veicoli.
     * @return i veicoli che soddisfano il predicato.
     */
    Set<Car<GridLocation>> getCars(Predicate<Car<L>> predicate);
    /**
     * Aggiunge un giocatore al game field.
     * @param player il giocatore da aggiungere al game field.
     * @return il giocatore appena creato.
     */
    Player<GridLocation> addPlayer(Player<L> player);

    /**
     * Conta tutti i veicoli che soddisfano un certo predicato.
     * @param predicate predicato per scegliere i veicoli.
     * @return il numero di veicoli che soddisfano il predicato.
     */
    int countCar(Predicate<Car<L>> predicate);

    /**
     * Restituisce l'insieme di posizioni in cui il veicolo potr&agrave; spostarsi.
     * @param car il veicolo di cui si vuole conoscere le prossime posizioni.
     * @return l'insieme di posizioni in cui il veicolo potr&agrave; spostarsi.
     */
    Set<L> getNextPossibleMoves (Car<L> car);

    /**
     * Restituisce tutte le mosse fatte dai giocatori in questo turno.
     * @return le mosse fatte dai giocatori.
     */
    Set<Move<L>> getMoves();

    /**
     * Aggiunge un movimento di un veicolo fatto da un giocatore in questo turno.
     * @param move movimento da registrare.
     */
    default void addMove(Move<L> move){
        if(!getMoves().add(move))
            throw new IllegalArgumentException("Il giocatore ha già fatto una mossa in questo turno");
        getMoves().add(move);
    }

    /**
     * Cancella tutti i movimenti fatti in questo turno.
     */
    void clearMoves();

    /**
     * Applica al campo da gioco la mossa fatta dai giocatori.
     */
    void nextStage();

}
