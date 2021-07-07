package it.unicam.cs.pa2021.formulaUno.model.printer;

import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.Location;

import java.util.Stack;

/**
 * Interfaccia funzionale con la responsabilit&agrave; di stampare un qualsiasi game field.
 */
@FunctionalInterface
public interface GameFieldPrinter<T extends GameField<L>, L extends Location> {

    /**
     * Colleziona uno stack di caratteri che rappresentano i vari corner di un dato game field.
     * @param field game field da stampare.
     * @return uno stack di caratteri.
     */
    Stack<Character> print(T field);
}
