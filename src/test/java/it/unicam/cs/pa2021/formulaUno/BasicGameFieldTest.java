package it.unicam.cs.pa2021.formulaUno;

import it.unicam.cs.pa2021.formulaUno.model.*;
import it.unicam.cs.pa2021.formulaUno.model.creator.BasicGameFieldCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.BotPlayerCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.GameFieldCreator;
import it.unicam.cs.pa2021.formulaUno.model.creator.PlayerCreator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.Optional;

public class BasicGameFieldTest {

    @Test
    public void buildField() throws IOException {
        File file = new File("circuitoLineare.txt");
        FileReader fileReader = new FileReader(file);
        CircuitReaderBasic reader= new CircuitReaderBasic(fileReader);
        PlayerCreator<GridLocation> playerCreator = new BotPlayerCreator<>();
        GameFieldCreator<GridLocation> fieldCreator = new BasicGameFieldCreator(playerCreator);

        int[][] track = reader.createCircuit();
        int height= reader.getTrackHeight();
        int width= reader.getTrackWidth();

        Deque<String> names = reader.namePlayers();
        BasicGameField field = (BasicGameField) fieldCreator.createGameField(width, height, track, names);

        BotPlayer<GridLocation> player1 = (BotPlayer<GridLocation>) field.getPlayers().stream().filter(p -> p.getName()=="Piero").findFirst().get();
        BotPlayer<GridLocation> player2 = (BotPlayer<GridLocation>) field.getPlayers().stream().filter(p -> p.getName()=="Testoli").findFirst().get();
        BotPlayer<GridLocation> player3 = (BotPlayer<GridLocation>) field.getPlayers().stream().filter(p -> p.getName()=="Mozz").findFirst().get();
        BotPlayer<GridLocation> player4 = (BotPlayer<GridLocation>) field.getPlayers().stream().filter(p -> p.getName()=="Cika").findFirst().get();
        Assertions.assertThrows(NullPointerException.class, () -> field.addPlayer(playerCreator.createPlayer("Asdrubale", field)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> field.addPlayer(playerCreator.createPlayer("Piero", field)));

        Move<GridLocation> move1 = player1.moveCarTo(Optional.empty());
        Move<GridLocation> move2 = player2.moveCarTo(Optional.empty());
        Move<GridLocation> move3 = player3.moveCarTo(Optional.empty());
        Move<GridLocation> move4 = player4.moveCarTo(Optional.empty());

        field.addMove(move1);
        field.addMove(move2);
        field.addMove(move3);
        field.addMove(move4);
        field.nextStage();

        if(player1.getCar().isInRace()){
            move1 = player1.moveCarTo(Optional.empty());
            field.addMove(move1);
        }

        if(player2.getCar().isInRace()){
            move2 = player2.moveCarTo(Optional.empty());
            field.addMove(move2);
        }

        if(player3.getCar().isInRace()){
            move3 = player3.moveCarTo(Optional.empty());
            field.addMove(move3);
        }

        if(player4.getCar().isInRace()){
            move4 = player4.moveCarTo(Optional.empty());
            field.addMove(move4);
        }

        if(field.getState())
            field.nextStage();
    }

}