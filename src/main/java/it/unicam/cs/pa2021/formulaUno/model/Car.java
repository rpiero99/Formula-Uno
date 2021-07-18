package it.unicam.cs.pa2021.formulaUno.model;

/**
 * Interfaccia che definisce un veicolo in un qualsiasi GameField.
 * @param <L> tipo per la posizione di un angolo
 */
public interface Car<L extends Location> {

    /**
     * Restituisce la posizione attuale in cui si trova il veicolo.
     * Se non è registrata nessuna posizione, verr&agrave; lanciata un IllegalArgumentException.
     * @return la posizione attuale del veicolo.
     */
    L getCurrentLocation();

    /**
     * Restituisce la precendente posizione occupata dal veicolo, utile per calcolare la prossima posizione.
     * @return la precendente posizione occupata dal veicolo. Se il veicolo ha registrata solo una posizione, vuol dire
     * che si trova nella posizione di partenza, per cui verr&agrave; restituita quella. Se non è registrata nessuna posizione,
     * verr&agrave; lanciata un IllegalArgumentException.
     */
    L getPreviousLocation();

    /**
     * Sposta il veicolo in un'altra posizione ed aggiorna la posizione precedente.
     * @param location nuova posizione in cui si trover&agrave; il veicolo.
     */
    void moveToNewLocation(L location);

    /**
     * Cambia lo stato del veicolo: ad esempio se esso ha subito un incidente, isInRace sar&agrave; messo a false.
     * @param status nuovo stato del veicolo.
     */
    void changeStatus(boolean status);

    /**
     * Restituisce true se il veicolo &egrave; ancora in corsa, false se esso ha subito un incidente.
     * @return true se il veicolo &egrave; ancora in corsa, false se esso ha subito un incidente.
     */
    boolean isInRace();

}
