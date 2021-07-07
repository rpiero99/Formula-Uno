package it.unicam.cs.pa2021.formulaUno.model.printer;

import it.unicam.cs.pa2021.formulaUno.model.BasicGameField;
import it.unicam.cs.pa2021.formulaUno.model.CircuitReaderBasic;
import it.unicam.cs.pa2021.formulaUno.model.GridLocation;
import it.unicam.cs.pa2021.formulaUno.model.Player;
import it.unicam.cs.pa2021.formulaUno.model.creator.BasicGameFieldCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.BotPlayerCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.GameFieldCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.PlayerCreator;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;

public class BasicGameFieldPrinterTest {

    @Test
    public void print() throws IOException {
        File file = new File("circuitoLineare.txt");
        FileReader fileReader = new FileReader(file);
        CircuitReaderBasic reader= new CircuitReaderBasic(fileReader);
        GameFieldCreator<GridLocation> fieldCreator = new BasicGameFieldCreator();
        int[][] track = reader.createCircuit();
        int height= reader.getTrackHeight();
        int width= reader.getTrackWidth();

        BasicGameField field = (BasicGameField) fieldCreator.createGameField(width, height, track);

        GameFieldPrinter<BasicGameField, GridLocation> printer = new BasicGameFieldPrinter();
        Deque<Character> characterDeque = printer.print(field);
        for(int row=0; row<height; row++){
            for(int col=0; col<width; col++){
                System.out.print(characterDeque.poll());
            }
        }
    }
}