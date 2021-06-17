package it.unicam.cs.pa2021.formulaUno.model;

/**
 * Interfaccia che definisce una movimento fatto da un giocatore su un generico veicolo.
 * @param <L> tipo per la posizione di un angolo
 */
public interface Move<L extends Location> {

    /**
     * Sposta un veicolo da una posizione ad un'altra
     * @param car veicolo da spostare
     * @param newLocation nuova posizione del veicolo.
     */
    void makeMove(Car<L> car, L newLocation);
}
