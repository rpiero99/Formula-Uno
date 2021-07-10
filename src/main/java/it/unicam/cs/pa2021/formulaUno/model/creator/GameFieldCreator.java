package it.unicam.cs.pa2021.formulaUno.model.creator;

import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.Location;

import java.util.Deque;

/**
 * Interfaccia responsabile della creazione di un game field.
 * @param <L> tipo per la posizione di un angolo.
 */
public interface GameFieldCreator<L extends Location> {

    /**
     * Crea e restituisce un game field grazie ai parametri passati.
     * @param width larghezza del game field.
     * @param height altezza del game field.
     * @param track istruzioni per la configurazione del game field.
     * @param players elenco dei giocatori iniziali del game field.
     * @return il game field appena creato.
     */
    GameField<L> createGameField(int width, int height, int[][] track, Deque<String> players);
}
