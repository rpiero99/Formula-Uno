package it.unicam.cs.pa2021.formulaUno;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasicGameFieldTest {

    @Test
    public void buildField(){
        int height= 10;
        int width=8;
        boolean[][] track = buildTrack(height, width);
        BasicGameField field = new BasicGameField(width, height, track);
        assertEquals(CornerStatus.IN_RACE, field.getCornerAt(new GridLocation(3, 2)).getStatus());
        assertEquals(CornerStatus.IN_RACE, field.getCornerAt(new GridLocation(4, 5)).getStatus());
    }

    private boolean[][] buildTrack(int height, int width) {
        boolean[][] track = new boolean[height][width];
        // prima riga poi colonna
        track[0][0] = true;
        track[0][1] = true;
        track[0][2] = true;
        track[0][3] = true;
        track[0][4] = true;
        track[1][0] = true;
        track[1][1] = true;
        track[1][2] = true;
        track[1][3] = true;
        track[1][4] = true;
        track[2][0] = true;
        track[2][1] = true;
        track[2][3] = true;
        track[2][4] = true;
        track[2][5] = true;
        track[2][6] = true;
        track[3][0] = true;
        track[3][1] = true;
        track[3][5] = true;
        track[3][6] = true;
        track[3][7] = true;
        track[4][0] = true;
        track[4][1] = true;
        track[4][6] = true;
        track[4][7] = true;
        track[5][0] = true;
        track[5][1] = true;
        track[5][3] = true;
        track[5][4] = true;
        track[5][6] = true;
        track[5][7] = true;
        track[6][0] = true;
        track[6][1] = true;
        track[6][2] = true;
        track[6][3] = true;
        track[6][4] = true;
        track[6][5] = true;
        track[6][6] = true;
        track[6][7] = true;
        track[7][0] = true;
        track[7][1] = true;
        track[7][2] = true;
        track[7][3] = true;
        track[7][5] = true;
        track[7][6] = true;
        track[7][7] = true;
        track[8][0] = true;
        track[8][1] = true;
        track[8][2] = true;
        track[8][5] = true;
        track[8][6] = true;
        track[8][7] = true;
        track[9][1] = true;
        track[9][2] = true;
        track[9][5] = true;
        track[9][6] = true;
        track[9][7] = true;
        return track;
    }

}