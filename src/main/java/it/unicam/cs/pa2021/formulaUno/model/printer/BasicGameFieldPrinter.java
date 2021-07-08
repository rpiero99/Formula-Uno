package it.unicam.cs.pa2021.formulaUno.model.printer;

import it.unicam.cs.pa2021.formulaUno.model.BasicGameField;
import it.unicam.cs.pa2021.formulaUno.model.Car;
import it.unicam.cs.pa2021.formulaUno.model.CornerStatus;
import it.unicam.cs.pa2021.formulaUno.model.GridLocation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Classe che implementa un generico printer di game field, in questo caso si occupa di stampare un basic game field.
 */
public class BasicGameFieldPrinter implements GameFieldPrinter<BasicGameField, GridLocation> {

    @Override
    public Deque<Character> print(BasicGameField gameField) {
        Deque<Character> characterDeque = new ArrayDeque<>();
        for(int row=0; row<gameField.getHeight(); row++){
            for(int col=0; col< gameField.getWidth(); col++){
                if(gameField.getCornerAt(new GridLocation(col, row)).getStatus()== CornerStatus.OUT_OF_RACE)
                    characterDeque.add('X');
                else if(gameField.getCornerAt(new GridLocation(col, row)).getStatus()== CornerStatus.IN_RACE)
                    characterDeque.add('-');
                else if(gameField.getCornerAt(new GridLocation(col, row)).getStatus()==CornerStatus.GOAL)
                    characterDeque.add('*');
                int finalCol = col;
                int finalRow = row;
                if(gameField.getCars(Car::isInRace).stream().anyMatch(c -> c.getCurrentLocation().equals(new GridLocation(finalCol, finalRow)))){
                    characterDeque.removeLast();
                    characterDeque.add('c');
                }
            }
            characterDeque.add('\n');
        }
        return characterDeque;
    }
}
