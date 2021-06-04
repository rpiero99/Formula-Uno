package it.unicam.cs.pa2021.formulaUno;

/**
 * Classe che implementa l'interfaccia Corner, in maniera di default.
 * @param <S> tipo di stato di un angolo
 * @param <L> tipo per la posizione di un angolo
 */
public class BasicCorner<S,L> implements Corner{

    private final GameField<S,L> field;
    private S status;
    private final L location;

    public BasicCorner(GameField<S, L> field, S status, L location) {
        this.field = field;
        this.status = status;
        this.location = location;
    }

    @Override
    public GameField<S,L> getField() {
        return this.field;
    }

    @Override
    public S getStatus() {
        return this.status;
    }

    @Override
    public L getLocation() {
        return this.location;
    }
}
