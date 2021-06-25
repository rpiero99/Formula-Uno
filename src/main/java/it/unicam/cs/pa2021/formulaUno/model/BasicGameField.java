package it.unicam.cs.pa2021.formulaUno.model;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Classe che implementa l'interfaccia GameField; descrive un classico campo formato da una griglia.
 */
public class BasicGameField implements GameField<GridLocation> {

    private final Corner<GridLocation>[][] cornerGrid;
    private final int width;
    private final int height;
    private final Set<Player<GridLocation>> players;
    private final Set<Move<GridLocation>> moves;

    /**
     * Crea un campo con le dimensioni date, in cui tutti gli angoli sono in uno stato di OUT_OF_RACE.
     * @param width larghezza del campo.
     * @param height altezza del campo.
     * @param track istruzioni per la configurazione del campo.
     */
    public BasicGameField(int width, int height, int [][] track) {
        this.width = width;
        this.height = height;
        this.players = new HashSet<>();
        this.moves = new HashSet<>();
        this.cornerGrid = new Corner[height][width];
        this.buildRaceTrack(track);
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Corner<GridLocation> getCornerAt(GridLocation location) {
        if (!isValidLocation(location))
            throw new ArrayIndexOutOfBoundsException("La posizione passata non è compresa in questo game field");
        return this.cornerGrid[location.getRow()][location.getColumn()];
    }

    @Override
    public Set<Player<GridLocation>> getPlayers() {
        return this.players;
    }

    @Override
    public Set<Car<GridLocation>> getCars(){
        return getPlayers().stream().map(Player::getCar).collect(Collectors.toSet());
    }

    @Override
    public Set<Car<GridLocation>> getCars(Predicate<Car<GridLocation>> predicate) {
        return getCars().stream().filter(predicate).collect(Collectors.toSet());
    }

    @Override
    public Player<GridLocation> addPlayer(Player<GridLocation> player) {
        if(getCornerAt(player.getCar().getCurrentLocation()).getStatus()!= CornerStatus.IN_RACE)
            throw new IllegalArgumentException("La posizione passata non può essere considerata per la posizione di partenza di un veicolo");
        if (!players.add(player))
            throw new IllegalArgumentException("Il giocatore è già presente nel game field, non può essere aggiunto");
        players.add(player);
        return player;
    }

    @Override
    public int countCar(Predicate<Car<GridLocation>> predicate) {
        return getCars(predicate)
                .size();
    }

    @Override
    public Set<GridLocation> getNextPossibleMoves(Car<GridLocation> car) {
        return car.getCurrentLocation().nextPossibleLocations(car, this);
    }

    @Override
    public Set<Move<GridLocation>> getMoves() {
        return this.moves;
    }

    @Override
    public void clearMoves() {
        this.moves.clear();
    }

    /**
     * Verifica se la locazione data &egrave; valida per il game field.
     *
     * @param loc locazione da verificare.
     * @return true se la locazione &grave; valida per il game field, false altrimenti.
     */
    private boolean isValidLocation(GridLocation loc) {
        return isValidLocation(loc.getRow(),loc.getColumn());
    }

    /**
     * Verifica se le righe e le colonne date sono valide per il game field.
     * @param row la riga da controllare.
     * @param column la colonna da controllare.
     * @return true se la locazione &grave; valida per il game field, false altrimenti.
     */
    private boolean isValidLocation(int row, int column) {
        return (0<=column)&&(column<width)&&(0<=row)&&(row<height);
    }

    @Override
    public void nextStage() {
        if(countCar(Car::isInRace) >1){
            getMoves().forEach(Move::apply);
            clearMoves();
            checkCollision();
            checkWinner();
        }

    }

    /**
     * Controlla se in questo turno un veicolo ha tagliato il traguardo. In quel caso, esso sar&agrave; considerato il vincitore.
     * Il gioco viene cos&igrave; fermato.
     */
    private void checkWinner() {
        //TODO: trova un modo per finire una partita.
        for (Car<GridLocation> car: getCars(Car::isInRace)) {
            if(getCornerAt(car.getCurrentLocation()).getStatus()==CornerStatus.GOAL)
                car.changeStatus(false);
        }
    }

    /**
     * Controlla se tutti veicoli che sono attualmente in corsa abbiano fatto un incidente in questo turno, ossia se sono usciti fuori dal cicuito,
     * oppure hanno occupato lo stesso angolo in questo turno.
     */
    private void checkCollision() {
        for (Car<GridLocation> car: getCars(Car::isInRace)) {
            GridLocation current = car.getCurrentLocation();
            if(getCornerAt(current).getStatus()==CornerStatus.OUT_OF_RACE || getCars().stream().filter(a -> a.getCurrentLocation().equals(current)).count()>1)
                car.changeStatus(false);
        }
    }

    /**
     * Costruisce il game field, in base alla matrice di int passata come parametro: se una cella &egrave; uguale a 1, far&agrave;
     * parte del circuito di gara; se una cella &egrave; uguale a 2 sar&agrave; parte del traguardo; mentre se &egrave; uguale a 0,
     * sar&agrave; fuori dal cirucito.
     * @param track istruzioni per la configurazione del campo.
     */
    private void buildRaceTrack(int[][] track){
        for(int row=0; row<height; row++){
            for(int column=0; column<width; column++){
                if(track[row][column]==1)
                    this.cornerGrid[row][column] = new BasicCorner<>(this, CornerStatus.IN_RACE, new GridLocation(column, row));
                else if(track[row][column]==2)
                    this.cornerGrid[row][column] = new BasicCorner<>(this, CornerStatus.GOAL, new GridLocation(column, row));
                else
                    this.cornerGrid[row][column] = new BasicCorner<>(this, CornerStatus.OUT_OF_RACE, new GridLocation(column, row));
            }
        }
    }
}
