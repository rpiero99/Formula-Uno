package it.unicam.cs.pa2021.formulaUno.model;

import java.io.Reader;

/**
 * Interfaccia che serve per creare un circuito da un qualsiasi file fornito in lettura.
 */
public interface CircuitReader {

    /**
     * Costruisce una matrice di int che servir&agrave; a costruire un nuovo game field per una corsa.
     * @param fileReader file di input
     * @return matrice che serve al game field per costruire un nuovo circuito.
     */
    int[][] createCircuit(Reader fileReader);
}
