package it.unicam.cs.pa2021.formulaUno.controller;

import it.unicam.cs.pa2021.formulaUno.model.BasicGameField;
import it.unicam.cs.pa2021.formulaUno.model.CircuitReaderBasic;
import it.unicam.cs.pa2021.formulaUno.model.GridLocation;
import it.unicam.cs.pa2021.formulaUno.model.creator.BasicGameFieldCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.BotPlayerCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.GameFieldCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.PlayerCreator;
import it.unicam.cs.pa2021.formulaUno.model.printer.BasicGameFieldPrinter;
import it.unicam.cs.pa2021.formulaUno.model.printer.GameFieldPrinter;
import it.unicam.cs.pa2021.formulaUno.view.ConsoleView;
import it.unicam.cs.pa2021.formulaUno.view.View;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;

public class SimpleControllerTest {

    @BeforeEach
    public void init() throws IOException {
        File file = new File("circuitoLineare.txt");
        FileReader fileReader = new FileReader(file);
        CircuitReaderBasic reader= new CircuitReaderBasic(fileReader);

        GameFieldCreator<GridLocation> fieldCreator = new BasicGameFieldCreator();
        PlayerCreator<GridLocation> playerCreator = new BotPlayerCreator<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        GameFieldPrinter<BasicGameField, GridLocation> printer = new BasicGameFieldPrinter();
        int[][] track = reader.createCircuit();
        int height= reader.getTrackHeight();
        int width= reader.getTrackWidth();

        BasicGameField field = (BasicGameField) fieldCreator.createGameField(width, height, track);
        View<BasicGameField, GridLocation> view = new ConsoleView<>(in, printer);

        Controller<BasicGameField, GridLocation> controller = new SimpleController<>(view, field);
    }

    @Test
    public void nextStage() {
    }

    @Test
    public void getGameField() {
    }

    @Test
    public void addPlayer() {
    }

    @Test
    public void addMove() {
    }

    @Test
    public void viewGameField() {
    }
}