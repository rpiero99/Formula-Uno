package it.unicam.cs.pa2021.formulaUno.model;

/**
 * Interfaccia che definisce una movimento fatto da un giocatore su un generico veicolo.
 * @param <L> tipo per la posizione di un angolo
 */

@FunctionalInterface
public interface Move<L extends Location> {

    /**
     * Sposta un veicolo da una posizione ad un'altra, controllando se effettivamente esso sia ancora in corsa:
     * in caso non lo sia, lancia un'eccezione
     */
    void apply();

}
