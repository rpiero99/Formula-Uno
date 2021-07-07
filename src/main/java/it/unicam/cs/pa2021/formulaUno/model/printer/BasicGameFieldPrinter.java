package it.unicam.cs.pa2021.formulaUno.model.printer;

import it.unicam.cs.pa2021.formulaUno.model.BasicGameField;
import it.unicam.cs.pa2021.formulaUno.model.CornerStatus;
import it.unicam.cs.pa2021.formulaUno.model.GridLocation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Classe che implementa un generico printer di game field, in questo caso si occupa di stampare un basic game field.
 */
public class BasicGameFieldPrinter implements GameFieldPrinter<BasicGameField, GridLocation> {

    @Override
    public Deque<Character> print(BasicGameField gameField) {
        Deque<Character> characterStack = new ArrayDeque<>();
        for(int row=0; row<gameField.getHeight(); row++){
            for(int col=0; col< gameField.getWidth(); col++){
                if(gameField.getCornerAt(new GridLocation(col, row)).getStatus()== CornerStatus.OUT_OF_RACE)
                    characterStack.add('X');
                else if(gameField.getCornerAt(new GridLocation(col, row)).getStatus()== CornerStatus.IN_RACE)
                    characterStack.add('-');
                else if(gameField.getCornerAt(new GridLocation(col, row)).getStatus()==CornerStatus.GOAL)
                    characterStack.add('*');
            }
            characterStack.add('\n');
        }
        return characterStack;
    }
}
