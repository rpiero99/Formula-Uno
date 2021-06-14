package it.unicam.cs.pa2021.formulaUno;

import junit.framework.TestCase;

import java.util.Set;

public class GridLocationTest extends TestCase {

    public void testNextPossibleLocations() {
        GridLocation firstLoc = new GridLocation(3,8);
        Car<CornerStatus,GridLocation> car= new SimpleCar(null,new BasicGameField(20,20),firstLoc);
        car.moveToNewLocation(new GridLocation(4,6));
        Set<GridLocation> nextLocations = car.getCurrentLocation().nextPossibleLocations(car);
        for (GridLocation a: nextLocations) {
            System.out.println(a.getColumn() + " " + a.getRow());
        }
    }


}