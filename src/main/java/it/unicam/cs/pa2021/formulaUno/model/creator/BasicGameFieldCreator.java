package it.unicam.cs.pa2021.formulaUno.model.creator;

import it.unicam.cs.pa2021.formulaUno.model.BasicGameField;
import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.GridLocation;

import java.util.Deque;
import java.util.logging.Logger;

/**
 * Classe responsabile della creazione di un basic game field.
 */
public class BasicGameFieldCreator implements GameFieldCreator<GridLocation> {

    private final PlayerCreator<GridLocation> playerCreator;
    private final Logger logger = Logger.getLogger("it.unicam.cs.pa2021.formulaUno.model.creator.BasicGameFieldCreator");

    /**
     * Costruttore del basic game field creator.
     * @param playerCreator creator per i giocatori del game field.
     */
    public BasicGameFieldCreator(PlayerCreator<GridLocation> playerCreator) {
        this.playerCreator = playerCreator;
    }

    @Override
    public GameField<GridLocation> createGameField(int width, int height, int[][] track, Deque<String> players) {
        BasicGameField field = new BasicGameField(width,height,track);
        for (String playerName : players) {
            field.addPlayer(playerCreator.createPlayer(playerName, field));
            logger.info("Giocatore "+playerName+" aggiunto al game field");
        }
        return field;
    }
}
