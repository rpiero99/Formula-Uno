/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.pa2021.formulaUno;

import it.unicam.cs.pa2021.formulaUno.controller.Controller;
import it.unicam.cs.pa2021.formulaUno.controller.SimpleController;
import it.unicam.cs.pa2021.formulaUno.model.BasicGameField;
import it.unicam.cs.pa2021.formulaUno.model.CircuitReaderBasic;
import it.unicam.cs.pa2021.formulaUno.model.GridLocation;
import it.unicam.cs.pa2021.formulaUno.model.Player;
import it.unicam.cs.pa2021.formulaUno.model.creator.BasicGameFieldCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.BotPlayerCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.GameFieldCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.PlayerCreator;
import it.unicam.cs.pa2021.formulaUno.model.printer.BasicGameFieldPrinter;
import it.unicam.cs.pa2021.formulaUno.model.printer.GameFieldPrinter;
import it.unicam.cs.pa2021.formulaUno.view.ConsoleView;
import it.unicam.cs.pa2021.formulaUno.view.View;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        menu();
        Scanner in = new Scanner(System.in);
        CircuitReaderBasic readerBasic;
        int choice = in.nextInt();
        if (choice == 1)
            readerBasic = initApp("circuito.txt");
        else if (choice == 2)
            readerBasic = initApp("circuitoLineare.txt");
        else
            throw new IllegalArgumentException("Devi digitare solamente uno dei numeri richiesti");

        PlayerCreator<GridLocation> playerCreator = new BotPlayerCreator<>();
        GameFieldCreator<GridLocation> gameFieldCreator = new BasicGameFieldCreator(playerCreator);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        GameFieldPrinter<BasicGameField, GridLocation> printer = new BasicGameFieldPrinter();
        BasicGameField field = createGameField(readerBasic, gameFieldCreator);
        View<BasicGameField, GridLocation> view = new ConsoleView<>(bufferedReader, printer);
        Controller<BasicGameField, GridLocation> controller = setController(field, view);
        controller.viewGameField();

        while (controller.getGameField().getState()) {
            for (Player<GridLocation> pl : controller.getGameField().getPlayers()) {
                if (pl.getCar().isInRace())
                    controller.addMove(pl.moveCarTo(Optional.empty()));
            }
            controller.nextStage();
            controller.viewGameField();
        }
        controller.closeView();
    }

    private static BasicGameField createGameField(CircuitReaderBasic readerBasic, GameFieldCreator<GridLocation> gameFieldCreator) throws IOException {
        int[][] track = readerBasic.createCircuit();
        int height = readerBasic.getTrackHeight();
        int width = readerBasic.getTrackWidth();
        return (BasicGameField) gameFieldCreator.createGameField(width, height, track, readerBasic.namePlayers());
    }

    private static Controller<BasicGameField, GridLocation> setController(BasicGameField field, View<BasicGameField, GridLocation> view) {
        Controller<BasicGameField, GridLocation> controller = new SimpleController<>(field);
        controller.recordView(view);
        return controller;
    }

    private static void menu() {
        System.out.println("Ciao, prima di iniziare a giocare scegli un circuito");
        System.out.println("Digita 1 : circuito (piccolo, 3 giocatori)");
        System.out.println("Digita 2 : circuitoLineare (medio, 4 giocatori)");
    }

    public static CircuitReaderBasic initApp(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        return new CircuitReaderBasic(fileReader);
    }
}
