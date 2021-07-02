package it.unicam.cs.pa2021.formulaUno.view;

import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.GridLocation;

import java.io.BufferedReader;

/**
 * Classe che rappresenta la vista di un game field direttamente su console.
 */
public class ConsoleView implements View<GridLocation> {

    private BufferedReader myInput;

    /**
     * Metodo costruttore al quale passo un oggetto BufferedReader per inserire comandi da tastiera.
     * @param myInput oggetto BufferedReader.
     */
    public ConsoleView(BufferedReader myInput){
        this.myInput=myInput;
    }

    @Override
    public void printGameField(GameField<GridLocation> field) {
        starting();
    }

    private void starting(){
        System.out.println("***************************");
        System.out.println("**      FORMULA UNO      **");
        System.out.println("***************************");
    }
}
