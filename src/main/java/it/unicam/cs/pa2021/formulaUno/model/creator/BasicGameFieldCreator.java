package it.unicam.cs.pa2021.formulaUno.model.creator;

import it.unicam.cs.pa2021.formulaUno.model.BasicGameField;
import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.GridLocation;

/**
 * Classe responsabile della creazione di un basic game field.
 */
public class BasicGameFieldCreator implements GameFieldCreator<GridLocation> {

    @Override
    public GameField<GridLocation> createGameField(int width, int height, int[][] track) {
        return new BasicGameField(width,height,track);
    }
}
