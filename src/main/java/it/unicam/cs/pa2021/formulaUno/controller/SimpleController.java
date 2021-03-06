package it.unicam.cs.pa2021.formulaUno.controller;

import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.Location;
import it.unicam.cs.pa2021.formulaUno.model.Move;
import it.unicam.cs.pa2021.formulaUno.model.Player;
import it.unicam.cs.pa2021.formulaUno.view.View;

/**
 * Semplice controller per questa applicazione, che coordina le basiche azioni di sistema.
 * @param <T> tipo di game field.
 * @param <L> tipo per la posizione di un angolo.
 */
public class SimpleController<T extends GameField<L>, L extends Location> implements Controller<T, L>{

    private View<T, L> view;
    private final T gameField;

    public SimpleController(T gameField) {
        this.gameField = gameField;
    }

    @Override
    public void nextStage() {
        this.gameField.nextStage();
    }

    @Override
    public void recordView(View<T, L> view) {
        this.view = view;
    }

    @Override
    public T getGameField() {
        return this.gameField;
    }

    @Override
    public Player<L> addPlayer(Player<L> player) {
        return this.gameField.addPlayer(player);
    }

    @Override
    public void addMove(Move<L> move) {
        this.gameField.addMove(move);
    }

    @Override
    public void viewGameField(){
        this.view.printGameField(gameField);
    }

    @Override
    public void closeView() {
        this.view.closeView();
    }
}
