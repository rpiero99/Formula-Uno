package it.unicam.cs.pa2021.formulaUno;

import java.util.Set;

/**
 * Interfaccia che definisce un campo da gioco di formula uno.
 * @param <S> tipo di stato di un angolo
 * @param <L> tipo per la posizione di un angolo
 */
public interface GameField <S,L> {

    /**
     * Restituisce un angolo ad una certa locazione.
     * @param location posizione nel campo da gioco.
     * @return l'angolo alla posizione data.
     */
    Corner<S,L> getCornerAt(L location);

    /**
     * Restituisce l'insieme degli angoli vicini alla posizione data.
     * @param location posizione nel campo da gioco.
     * @return l'insieme degli angoli vicini alla posizione data.
     */
    Set<Corner<S,L>> getAdjacentCorners(L location);

    /**
     * Applica al campo da gioco le mosse fatte dai giocatori.
     * @param moves le mosse dei giocatori.
     * @return il nuovo campo con l'applicazione delle mosse.
     */
    GameField<S, L> nextMove(Move<S,L> moves);
}
