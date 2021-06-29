package it.unicam.cs.pa2021.formulaUno.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe che ha la responsabilit&agrave; di costruire una matrice per permettere ad un game field di
 * costruire un circuito competitivo per una gara.
 */
public class CircuitReaderBasic implements CircuitReader {

    private final Reader fileReader;
    private final Set<String> namePlayers;

    public CircuitReaderBasic(Reader fileReader) {
        this.fileReader = fileReader;
        this.namePlayers = new HashSet<>();
    }

    @Override
    public int[][] createCircuit() throws IOException {
        BufferedReader in = new BufferedReader(fileReader);
        String[] infos = in.readLine().split(";");
        int width = Integer.parseInt(infos[0]);
        int height = Integer.parseInt(infos[1]);
        namePlayers.addAll(Arrays.asList(infos).subList(2, infos.length));
        int[][] circuit = buildCircuit(in, width, height);
        in.close();
        return circuit;
    }

    @Override
    public Set<String> namePlayers() {
        return namePlayers;
    }

    private int[][] buildCircuit(BufferedReader in, int width, int height) throws IOException {
        int[][] circuit = new int[height][width];

        for(int r = 0; r< height; r++){
            in.readLine();
            for(int c = 0; c< width; c++){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((char)in.read());
            }
        }
        return circuit;
    }
}
