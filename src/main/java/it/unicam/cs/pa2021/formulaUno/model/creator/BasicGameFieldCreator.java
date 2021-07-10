package it.unicam.cs.pa2021.formulaUno.model.creator;

import it.unicam.cs.pa2021.formulaUno.model.BasicGameField;
import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.GridLocation;
import it.unicam.cs.pa2021.formulaUno.model.Player;

import java.util.Deque;

/**
 * Classe responsabile della creazione di un basic game field.
 */
public class BasicGameFieldCreator implements GameFieldCreator<GridLocation> {

    private final PlayerCreator<GridLocation> playerCreator;

    public BasicGameFieldCreator(PlayerCreator<GridLocation> playerCreator) {
        this.playerCreator = playerCreator;
    }

    @Override
    public GameField<GridLocation> createGameField(int width, int height, int[][] track, Deque<String> players) {
        BasicGameField field = new BasicGameField(width,height,track);
        for (String playerName : players) {
            field.addPlayer(playerCreator.createPlayer(playerName));
        }
        return field;
    }
}
