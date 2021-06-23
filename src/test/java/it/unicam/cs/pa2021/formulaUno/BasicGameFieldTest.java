package it.unicam.cs.pa2021.formulaUno;

import it.unicam.cs.pa2021.formulaUno.model.*;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class BasicGameFieldTest {

    @Test
    public void buildField(){
        int height= 10;
        int width=8;
        int[][] track = buildTrack(height, width);
        GridLocation loc1 = new GridLocation(0,4);
        GridLocation loc2 = new GridLocation(1,4);
        GridLocation loc3 = new GridLocation(0, 3);

        BasicGameField field = new BasicGameField(width, height, track);
        Player<GridLocation> player1 = field.addPlayer(new BotPlayer("Piero", loc1));
        Player<GridLocation> player2 = field.addPlayer(new BotPlayer("Testolì", loc2));
        Player<GridLocation> player3 = field.addPlayer(new BotPlayer("Moz", loc3));
        assertEquals(CornerStatus.IN_RACE, field.getCornerAt(new GridLocation(3, 2)).getStatus());
        assertEquals(CornerStatus.IN_RACE, field.getCornerAt(new GridLocation(4, 5)).getStatus());

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

    private int[][] buildTrack(int height, int width) {
        int[][] track = new int[height][width];
        // prima riga poi colonna
        track[0][0] = 1;
        track[0][1] = 1;
        track[0][2] = 1;
        track[0][3] = 1;
        track[0][4] = 1;
        track[1][0] = 1;
        track[1][1] = 1;
        track[1][2] = 1;
        track[1][3] = 1;
        track[1][4] = 1;
        track[2][0] = 1;
        track[2][1] = 1;
        track[2][3] = 1;
        track[2][4] = 1;
        track[2][5] = 1;
        track[2][6] = 1;
        track[3][0] = 1;
        track[3][1] = 1;
        track[3][5] = 1;
        track[3][6] = 1;
        track[3][7] = 1;
        track[4][0] = 1;
        track[4][1] = 1;
        track[4][6] = 1;
        track[4][7] = 1;
        track[5][0] = 1;
        track[5][1] = 1;
        track[5][3] = 1;
        track[5][4] = 1;
        track[5][6] = 1;
        track[5][7] = 1;
        track[6][0] = 1;
        track[6][1] = 1;
        track[6][2] = 1;
        track[6][3] = 1;
        track[6][4] = 1;
        track[6][5] = 1;
        track[6][6] = 1;
        track[6][7] = 1;
        track[7][0] = 1;
        track[7][1] = 1;
        track[7][2] = 1;
        track[7][3] = 1;
        track[7][5] = 1;
        track[7][6] = 1;
        track[7][7] = 1;
        track[8][0] = 1;
        track[8][1] = 1;
        track[8][2] = 1;
        track[8][5] = 1;
        track[8][6] = 1;
        track[8][7] = 1;
        track[9][1] = 1;
        track[9][2] = 1;
        track[9][5] = 1;
        track[9][6] = 1;
        track[9][7] = 1;
        return track;
    }

}