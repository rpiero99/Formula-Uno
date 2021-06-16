package it.unicam.cs.pa2021.formulaUno.model;

/**
 * Interfaccia che definisce un generico angolo di un GameField.
 * @param <L> tipo per la posizione di un angolo
 */
public interface Corner<L extends Location> {

    /**
     * Restituisce il campo da gioco in cui si trova l'angolo.
     * @return il campo da gioco in cui si trova l'angolo.
     */
    GameField<L> getField();

    /**
     * Restuisce lo stato attuale dell'angolo.
     * @return lo stato attuale dell'angolo.
     */
    CornerStatus getStatus();

    /**
     * Restituisce la posizione dell'angolo nel campo da gioco.
     * @return la posizione dell'angolo nel campo da gioco.
     */
    L getLocation();

    /**
     * Cambia lo stato dell'angolo.
     * @param status stato che sostituisce l'attuale.
     */
    void changeStatus(CornerStatus status);
}
