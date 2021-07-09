package it.unicam.cs.pa2021.formulaUno.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * Classe che ha la responsabilit&agrave; di costruire una matrice per permettere ad un game field di
 * costruire un circuito competitivo per una gara.
 */
public class CircuitReaderBasic implements CircuitReader {

    private final Reader fileReader;
    private final Deque<String> namePlayers;
    private int width;
    private int height;

    public CircuitReaderBasic(Reader fileReader) {
        this.fileReader = fileReader;
        this.namePlayers = new ArrayDeque<>();
    }

    @Override
    public int[][] createCircuit() throws IOException {
        BufferedReader in = new BufferedReader(fileReader);
        String[] infos = in.readLine().split(";");
        this.width = Integer.parseInt(infos[0]);
        this.height = Integer.parseInt(infos[1]);
        namePlayers.addAll(Arrays.asList(infos).subList(2, infos.length));
        int[][] circuit = buildCircuit(in, width, height);
        in.close();
        return circuit;
    }

    @Override
    public Deque<String> namePlayers() {
        return namePlayers;
    }

    @Override
    public int getTrackWidth() {
        return this.width;
    }

    @Override
    public int getTrackHeight() {
        return this.height;
    }

    private int[][] buildCircuit(BufferedReader in, int width, int height) throws IOException {
        int[][] circuit = new int[height][width];

        for(int r = 0; r< height; r++){
            in.readLine();
            for(int c = 0; c< width; c++){
                char current = (char) in.read();
                if(current =='x')
                    circuit[r][c] = 0;
                else if(current =='-')
                    circuit[r][c] = 1;
                else if(current == '*')
                    circuit[r][c] = 2;
                else if(current == '+')
                    circuit[r][c] = 3;
            }
        }
        return circuit;
    }
}
