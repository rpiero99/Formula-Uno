package it.unicam.cs.pa2021.formulaUno.model;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     */
    public BasicGameField(int width, int height, boolean [][] track) {
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

    /**
     * Restituisce tutti i veicoli appartenenti a questo game field.
     * @return i veicoli appartenenti a questo game field.
     */
    private Set<Car<GridLocation>> getCars(){
        return getPlayers().stream().map(Player::getCar).collect(Collectors.toSet());
    }

    @Override
    public Player<GridLocation> addPlayer(Player<GridLocation> player) {
        if(getCornerAt(player.getCar().getCurrentLocation()).getStatus()!= CornerStatus.IN_RACE)
            throw new IllegalArgumentException("La posizione passata non può essere considerata per la posizione di partenza di un veicolo");
        if (!players.add(player))
            throw new IllegalArgumentException("Il giocatore è già presente nel game field, non può essere aggiunto");
        players.add(player);
        player.setField(this);
        return player;
    }

    @Override
    public int countCar(Predicate<Car<GridLocation>> predicate) {
        return (int) getCars()
                .stream()
                .filter(predicate)
                .count();
    }

    @Override
    public Set<GridLocation> getNextPossibleMoves(Car<GridLocation> car) {
        return car.getCurrentLocation().nextPossibleLocations(car);
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
        if(!(countCar(Car::isInRace)==0)){
            getMoves().forEach(Move::apply);
            clearMoves();
        }

    }

    private void buildRaceTrack(boolean[][] track){
        for(int row=0; row<height; row++){
            for(int column=0; column<width; column++){
                if(track[row][column])
                    this.cornerGrid[row][column] = new BasicCorner<>(this, CornerStatus.IN_RACE, new GridLocation(column, row));
                else
                    this.cornerGrid[row][column] = new BasicCorner<>(this, CornerStatus.OUT_OF_RACE, new GridLocation(column, row));
            }
        }
    }
}
