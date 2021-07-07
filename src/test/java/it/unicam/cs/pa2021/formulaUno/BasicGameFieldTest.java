package it.unicam.cs.pa2021.formulaUno;

import it.unicam.cs.pa2021.formulaUno.model.*;
import it.unicam.cs.pa2021.formulaUno.model.creator.BasicGameFieldCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.BotPlayerCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.GameFieldCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.PlayerCreator;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.*;

public class BasicGameFieldTest {

    @Test
    public void buildField() throws IOException {
        File file = new File("circuito.txt");
        FileReader fileReader = new FileReader(file);
        CircuitReaderBasic reader= new CircuitReaderBasic(fileReader);
        GameFieldCreator<GridLocation> fieldCreator = new BasicGameFieldCreator();
        PlayerCreator<GridLocation> playerCreator = new BotPlayerCreator<>();
        int[][] track = reader.createCircuit();
        int height= reader.getTrackHeight();
        int width= reader.getTrackWidth();
        GridLocation loc1 = new GridLocation(1,6);
        GridLocation loc2 = new GridLocation(2,6);
        GridLocation loc3 = new GridLocation(3, 6);

        BasicGameField field = (BasicGameField) fieldCreator.createGameField(width, height, track);
        Player<GridLocation> player1 = field.addPlayer(playerCreator.createPlayer("Piero", loc1));
        Player<GridLocation> player2 = field.addPlayer(playerCreator.createPlayer("Testolì", loc2));
        Player<GridLocation> player3 = field.addPlayer(playerCreator.createPlayer("Moz", loc3));

        Move<GridLocation> move1 = player1.moveCarTo(field.getNextPossibleMoves(player1.getCar()));
        Move<GridLocation> move2 = player2.moveCarTo(field.getNextPossibleMoves(player2.getCar()));
        Move<GridLocation> move3 = player3.moveCarTo(field.getNextPossibleMoves(player3.getCar()));

        field.addMove(move1);
        field.addMove(move2);
        field.addMove(move3);
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

        field.nextStage();
    }

}