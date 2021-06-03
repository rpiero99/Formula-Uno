package it.unicam.cs.pa2021.formulaUno;

/**
 * Interfaccia che definisce un veicolo in un qualsiasi GameField.
 * @param <S> tipo di stato di un angolo
 * @param <L> tipo per la posizione di un angolo
 */
public interface Car<S, L extends Location> {

    /**
     * Restituisce il giocatore proprietario del veicolo.
     * @return il giocatore proprietario del veicolo.
     */
    Player<S,L> getPlayer();

    /**
     * Restituisce il campo da gioco in cui si trova il veicolo.
     * @return il campo da gioco in cui si trova il veicolo.
     */
    GameField<S,L> getField();

    /**
     * Restituisce la posizione attuale in cui si trova il veicolo.
     * @return la posizione attuale del veicolo.
     */
    L getCurrentLocation();


    /**
     * Restituisce la precendente posizione occupata dal veicolo, utile per calcolare la prossima posizione.
     * @return la precendente posizione occupata dal veicolo.
     */
    L getPreviousLocation();

    /**
     * Sposta il veicolo in un'altra posizione ed aggiorna la posizione precedente.
     * @param location nuova posizione in cui si trover&agrave; il veicolo.
     */
    void moveToNewLocation(L location);

    /**
     * Restituisce true se il veicolo &egrave; ancora in corsa, false se esso ha subito un incidente.
     * @return true se il veicolo &egrave; ancora in corsa, false se esso ha subito un incidente.
     */
    boolean isInRace();

}