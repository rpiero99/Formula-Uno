package it.unicam.cs.pa2021.formulaUno.view;

import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.Location;

/**
 * Interfaccia che consente all'utente di implementare diversi modi per rappresentare graficamente un game field.
 * @param <L> tipo per la posizione di un angolo
 */
public interface View<L extends Location> {

    /**
     * Con questo metodo si ottiene una vista di un game field.
     * @param field field da visualizzare.
     */
    void printGameField(GameField<L> field);
}
