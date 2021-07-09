package it.unicam.cs.pa2021.formulaUno;

import it.unicam.cs.pa2021.formulaUno.model.*;
import it.unicam.cs.pa2021.formulaUno.model.creator.BasicGameFieldCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.BotPlayerCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.GameFieldCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.PlayerCreator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.Set;

import static org.junit.Assert.*;

public class BasicGameFieldTest {

    @Test
    public void buildField() throws IOException {
        File file = new File("circuitoLineare.txt");
        FileReader fileReader = new FileReader(file);
        CircuitReaderBasic reader= new CircuitReaderBasic(fileReader);
        GameFieldCreator<GridLocation> fieldCreator = new BasicGameFieldCreator();
        PlayerCreator<GridLocation> playerCreator = new BotPlayerCreator<>();
        int[][] track = reader.createCircuit();
        int height= reader.getTrackHeight();
        int width= reader.getTrackWidth();

        BasicGameField field = (BasicGameField) fieldCreator.createGameField(width, height, track);
        Deque<String> names = reader.namePlayers();
        Player<GridLocation> player1 = field.addPlayer(playerCreator.createPlayer(names.poll()));
        Player<GridLocation> player2 = field.addPlayer(playerCreator.createPlayer(names.poll()));
        Player<GridLocation> player3 = field.addPlayer(playerCreator.createPlayer(names.poll()));
        Player<GridLocation> player4 = field.addPlayer(playerCreator.createPlayer(names.poll()));
        Assertions.assertThrows(NullPointerException.class, () -> field.addPlayer(playerCreator.createPlayer("Asdrubale")));
        Assertions.assertThrows(IllegalArgumentException.class, () -> field.addPlayer(playerCreator.createPlayer("Piero")));

        Move<GridLocation> move1 = player1.moveCarTo(field.getNextPossibleMoves(player1.getCar()));
        Move<GridLocation> move2 = player2.moveCarTo(field.getNextPossibleMoves(player2.getCar()));
        Move<GridLocation> move3 = player3.moveCarTo(field.getNextPossibleMoves(player3.getCar()));
        Move<GridLocation> move4 = player4.moveCarTo(field.getNextPossibleMoves(player4.getCar()));

        field.addMove(move1);
        field.addMove(move2);
        field.addMove(move3);
        field.addMove(move4);
        field.nextStage();

        if(player1.getCar().isInRace()){
            move1 = player1.moveCarTo(field.getNextPossibleMoves(player1.getCar()));
            field.addMove(move1);
        }

        if(player2.getCar().isInRace()){
            move2 = player2.moveCarTo(field.getNextPossibleMoves(player2.getCar()));
            field.addMove(move2);
        }

        if(player3.getCar().isInRace()){
            move3 = player3.moveCarTo(field.getNextPossibleMoves(player3.getCar()));
            field.addMove(move3);
        }

        if(player4.getCar().isInRace()){
            move4 = player4.moveCarTo(field.getNextPossibleMoves(player4.getCar()));
            field.addMove(move4);
        }

        if(field.getState())
            field.nextStage();
    }

}