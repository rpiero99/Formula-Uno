package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Interfaccia che definisce un campo da gioco di formula uno.
 * @param <L> tipo per la posizione di un angolo.
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
    Set<Car<L>> getCars();

    /**
     * Restituisce tutti i veicoli che soddisfano un dato predicato.
     * @param predicate predicato per scegliere i veicoli.
     * @return i veicoli che soddisfano il predicato.
     */
    Set<Car<L>> getCars(Predicate<Car<L>> predicate);

    /**
     * Restituisce true se in quella posizione ci &egrave; attualmente allocato un veicolo, false altrimenti.
     * @param location posizione da controllare.
     * @return esito del controllo.
     */
    boolean isThereACar(L location);

    /**
     * Aggiunge un giocatore al game field, lanciando un eccezione se esso &egrave; gi&agrave; presente nel game field.
     * @param player il giocatore da aggiungere al game field.
     * @return il giocatore appena creato.
     */
    Player<L> addPlayer(Player<L> player);

    /**
     * Restituisce tutti gli angoli del game field, sottoforma di set.
     * @return gli angoli del game field.
     */
    Set<Corner<L>> getCorners();

    /**
     * Restituisce un insieme di angoli che soddisfano un certo predicato.
     * @param predicate predicato per scegliere gli angoli.
     * @return l'insieme di angoli che soddisfano il predicato.
     */
    Set<Corner<L>> getCorners(Predicate<Corner<L>> predicate);

    /**
     * Conta tutti i veicoli che soddisfano un certo predicato.
     * @param predicate predicato per scegliere i veicoli.
     * @return il numero di veicoli che soddisfano il predicato.
     */
    int countCar(Predicate<Car<L>> predicate);

    /**
     * Restituisci lo stato attuale della gara: true se &egrave; ancora in corso, false altrimenti.
     * @return true se la gara &egrave; ancora in corso, false altrimenti.
     */
    boolean getState();

    /**
     * Cambia lo stato della gara in corsa.
     * @param state nuovo stato della gara.
     */
    void changeState(boolean state);

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
     * Applica al campo da gioco i movimenti fatti dai giocatori in questo turno.
     */
    void nextStage();

    /**
     * Restituisce il vincitore di questa gara.
     * @return il vincitore di questa gara.
     */
    Optional<Player<L>> getWinner();

}
