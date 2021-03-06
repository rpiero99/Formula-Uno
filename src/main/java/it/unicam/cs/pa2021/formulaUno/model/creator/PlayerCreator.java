package it.unicam.cs.pa2021.formulaUno.model.creator;

import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.Location;
import it.unicam.cs.pa2021.formulaUno.model.Player;

/**
 * Interfaccia responsabile per la creazione di un player in un game field.
 * @param <L> tipo per la posizione di un angolo.
 */
public interface PlayerCreator<L extends Location> {

    /**
     * Crea e restituisce un giocatore grazie ai parametri passati.
     * @param name nome per il nuovo giocatore.
     * @param field game field del nuovo giocatore.
     * @return il giocatore creato.
     */
    Player<L> createPlayer(String name, GameField<L> field);
}
