package it.unicam.cs.pa2021.formulaUno;

/**
 * Interfaccia che definisce un generico angolo di un GameField.
 * @param <S> tipo di stato di un angolo
 * @param <L> tipo per la posizione di un angolo
 */
public interface Corner<S,L extends Location> {

    /**
     * Restituisce il campo da gioco in cui si trova l'angolo.
     * @return il campo da gioco in cui si trova l'angolo.
     */
    GameField<S,L> getField();

    /**
     * Restuisce lo stato attuale dell'angolo.
     * @return lo stato attuale dell'angolo.
     */
    S getStatus();

    /**
     * Restituisce la posizione dell'angolo nel campo da gioco.
     * @return la posizione dell'angolo nel campo da gioco.
     */
    L getLocation();

    /**
     * Cambia lo stato dell'angolo.
     * @param status stato che sostituisce l'attuale.
     */
    void changeStatus(S status);
}
