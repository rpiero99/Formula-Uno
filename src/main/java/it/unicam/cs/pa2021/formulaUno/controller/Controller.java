package it.unicam.cs.pa2021.formulaUno.controller;


import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.Location;
import it.unicam.cs.pa2021.formulaUno.model.Move;
import it.unicam.cs.pa2021.formulaUno.model.Player;
import it.unicam.cs.pa2021.formulaUno.view.View;

/**
 * Controller del pattern MVC, che coordina le azioni da eseguire ad un game field, attraverso la definizione di una view.
 * @param <L> tipo per la posizione di un angolo.
 */
public interface Controller<T extends GameField<L>, L extends Location> {

    /**
     * Applica al game field associato i movimenti fatti dai giocatori in questo turno.
     */
    void nextStage();

    /**
     * Registra al controller una view specifica.
     * @param view da associare al controller.
     */
    void recordView(View<T, L> view);

    /**
     * Restituisce il game field associato al controller.
     * @return il game field associato.
     */
    T getGameField();

    /**
     * Aggiunge un giocatore al game field associato.
     * @param player giocatore da aggiungere
     * @return il giocatore appena aggiunto.
     */
    Player<L> addPlayer(Player<L> player);

    /**
     * Aggiunge un movimento di un veicolo fatto da un giocatore in questo turno.
     * @param move movimento da registrare.
     */
    void addMove(Move<L> move);

    /**
     * Fornisce una vista al game field associato al controller.
     */
    void viewGameField();

    /**
     * Chiude la vista aperta in precedenza.
     */
    void closeView();
}
