package it.unicam.cs.pa2021.formulaUno;

/**
 * Interfaccia che definisce un generico angolo di un quadretto.
 * @param <S> tipo di stato di un angolo
 * @param <L> tipo per la posizione di un angolo
 */
public interface Corner<S,L> {

    /**
     * Restituisce il campo da gioco in cui si trova l'angolo.
     * @return l campo da gioco in cui si trova l'angolo.
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
}
