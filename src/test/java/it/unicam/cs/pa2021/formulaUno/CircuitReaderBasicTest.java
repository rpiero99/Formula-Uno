package it.unicam.cs.pa2021.formulaUno;

import it.unicam.cs.pa2021.formulaUno.model.CircuitReaderBasic;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CircuitReaderBasicTest {

    @Test
    public void createCircuit() throws IOException {
        File file = new File("circuito.txt");
        FileReader fileReader = new FileReader(file);
        CircuitReaderBasic reader= new CircuitReaderBasic(fileReader);
        reader.createCircuit();
    }
}