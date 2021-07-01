package it.unicam.cs.pa2021.formulaUno.model;

import java.io.IOException;
import java.io.Reader;
import java.util.Set;

/**
 * Interfaccia che serve per creare un circuito da un qualsiasi file fornito in lettura.
 */
public interface CircuitReader {

    /**
     * Costruisce una matrice di int che servir&agrave; a costruire un nuovo game field per una corsa.
     * @return matrice che serve al game field per costruire un nuovo circuito.
     */
    int[][] createCircuit() throws IOException;

    /**
     * Restituisce i giocatori che partecipano alla corsa.
     * @return i nomi dei giocatori che partecipano alla corsa.
     */
    Set<String> namePlayers() throws IOException;

    /**
     * Restituisce la larghezza del circuito creato, in base alle info prese dal file.
     * @return la larghezza del circuito creato.
     */
    int getTrackWidth();

    /**
     *  Restituisce l'altezza del circuito creato, in base alle info prese dal file.
     * @return l'altezza del circuito creato.
     */
    int getTrackHeight();
}
