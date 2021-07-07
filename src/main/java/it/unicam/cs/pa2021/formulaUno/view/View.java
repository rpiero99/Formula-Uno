package it.unicam.cs.pa2021.formulaUno.view;

import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.Location;

/**
 * Interfaccia che consente all'utente di implementare diversi modi per rappresentare graficamente un game field.
 * @param <T> tipo di game field.
 * @param <L> tipo per la posizione di un angolo
 */
public interface View<T extends GameField<L>, L extends Location> {

    /**
     * Con questo metodo si ottiene una vista di un game field.
     * @param gameField game field da visualizzare.
     */
    void printGameField(T gameField);

    /**
     * Termina la vista del game field.
     */
    void closeView();
}
