package it.unicam.cs.pa2021.formulaUno.view;

import it.unicam.cs.pa2021.formulaUno.model.GameField;
import it.unicam.cs.pa2021.formulaUno.model.Location;
import it.unicam.cs.pa2021.formulaUno.model.printer.GameFieldPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Deque;

/**
 * Classe che rappresenta la vista di un game field direttamente su console.
 */
public class ConsoleView <T extends GameField<L>, L extends Location> implements View<T, L> {

    private final BufferedReader myInput;
    private final GameFieldPrinter<T, L> printer;

    /**
     * Metodo costruttore al quale passo un oggetto BufferedReader per inserire comandi da tastiera.
     * @param myInput oggetto BufferedReader.
     */
    public ConsoleView(BufferedReader myInput, GameFieldPrinter<T, L> printer){
        this.myInput=myInput;
        this.printer=printer;
    }

    @Override
    public void printGameField(T field) {
        starting();
        while (field.getState()){
           printMatrix(field);
        }
        goodByes();
    }

    @Override
    public void closeView() {
        try {
            myInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void starting(){
        System.out.println("***************************");
        System.out.println("**      FORMULA UNO      **");
        System.out.println("***************************");
    }

    private void goodByes() {
        System.out.println("Fine della partita, riavvia l'applicazione per giocare di nuovo");
    }

    private void printMatrix(T field) {
        Deque<Character> characterStack = printer.print(field);
        for (char a: characterStack) {
            System.out.print(a);
        }
    }
}
