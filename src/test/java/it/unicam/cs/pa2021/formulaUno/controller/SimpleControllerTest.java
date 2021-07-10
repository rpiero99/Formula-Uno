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

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleControllerTest {

    Controller<BasicGameField, GridLocation> controller;
    BasicGameField field;
    PlayerCreator<GridLocation> playerCreator;
    GameFieldCreator<GridLocation> fieldCreator;

    @Test
    public void init() throws IOException {
        File file = new File("circuitoLineare.txt");
        FileReader fileReader = new FileReader(file);
        CircuitReaderBasic reader= new CircuitReaderBasic(fileReader);

        playerCreator = new BotPlayerCreator<>();
        fieldCreator = new BasicGameFieldCreator(playerCreator);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        GameFieldPrinter<BasicGameField, GridLocation> printer = new BasicGameFieldPrinter();
        int[][] track = reader.createCircuit();
        int height= reader.getTrackHeight();
        int width= reader.getTrackWidth();

        field = (BasicGameField) fieldCreator.createGameField(width, height, track, reader.namePlayers());
        View<BasicGameField, GridLocation> view = new ConsoleView<>(in, printer);

        controller = new SimpleController<>(view, field);
        assertNotNull(controller.getGameField());
        controller.viewGameField();

        while (controller.getGameField().getState()){
            controller.makeMoves();
            controller.nextStage();
            controller.viewGameField();
        }
    }


}