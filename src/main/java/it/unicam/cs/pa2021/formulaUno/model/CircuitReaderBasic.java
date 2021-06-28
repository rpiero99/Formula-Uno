package it.unicam.cs.pa2021.formulaUno.model;

import java.io.Reader;

/**
 * Classe che ha la responsabilit&agrave; di costruire una matrice per permettere ad un game field di
 * costruire un circuito competitivo per una gara.
 */
public class CircuitReaderBasic implements CircuitReader {

    

    @Override
    public int[][] createCircuit(Reader fileReader) {
        return new int[0][];
    }
}
