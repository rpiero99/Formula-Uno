package it.unicam.cs.pa2021.formulaUno.model.creator;

import it.unicam.cs.pa2021.formulaUno.model.BotPlayer;
import it.unicam.cs.pa2021.formulaUno.model.Location;
import it.unicam.cs.pa2021.formulaUno.model.Player;

public class BotPlayerCreator<L extends Location> implements PlayerCreator<L>{

    @Override
    public Player<L> createPlayer(String name, L initialPosition) {
        return new BotPlayer<>(name, initialPosition);
    }
}
