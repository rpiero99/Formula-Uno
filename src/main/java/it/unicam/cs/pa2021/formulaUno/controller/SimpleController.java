package it.unicam.cs.pa2021.formulaUno.controller;

import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.Location;
import it.unicam.cs.pa2021.formulaUno.model.Move;
import it.unicam.cs.pa2021.formulaUno.view.View;

/**
 * Semplice controller per questa applicazione, che coordina le basiche azioni di sistema.
 * @param <L> tipo per la posizione di un angolo.
 */
public class SimpleController<L extends Location> implements Controller<L>{
//TODO meglio

    private final View<L> view;
    private final GameField<L> gameField;

    public SimpleController(View<L> view, GameField<L> gameField) {
        this.view = view;
        this.gameField = gameField;
    }

    @Override
    public void nextStage() {
        this.gameField.nextStage();
    }

    @Override
    public GameField<L> getGameField() {
        return this.gameField;
    }

    @Override
    public void addMove(Move<L> move) {
        this.gameField.addMove(move);
    }

    @Override
    public void viewGameField(){
        this.view.printGameField(gameField);
    }
}
