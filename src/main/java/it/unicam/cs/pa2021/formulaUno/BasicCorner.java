package it.unicam.cs.pa2021.formulaUno;

/**
 * Classe che implementa l'interfaccia Corner, in maniera di default.
 * @param <L> tipo per la posizione di un angolo
 */
public class BasicCorner<L extends Location> implements Corner<L>{

    private final GameField<L> field;
    private CornerStatus status;
    private final L location;

    public BasicCorner(GameField<L> field, CornerStatus status, L location) {
        this.field = field;
        this.status = status;
        this.location = location;
    }

    @Override
    public GameField<L> getField() {
        return this.field;
    }

    @Override
    public CornerStatus getStatus() {
        return this.status;
    }

    @Override
    public L getLocation() {
        return this.location;
    }

    @Override
    public void changeStatus(CornerStatus status) {
        this.status= status;
    }
}
