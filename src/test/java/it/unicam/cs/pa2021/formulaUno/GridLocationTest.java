package it.unicam.cs.pa2021.formulaUno;

import junit.framework.TestCase;

import java.util.Set;

public class GridLocationTest extends TestCase {

    public void testNextPossibleLocations() {
        GridLocation firstLoc = new GridLocation(5,7);
        Car<CornerStatus,GridLocation> car= new SimpleCar(null,new BasicGameField(20,20),firstLoc);
        car.moveToNewLocation(new GridLocation(6,4));
        Set<GridLocation> nextLocations = car.getCurrentLocation().nextPossibleLocations(car);
        assertTrue(nextLocations.contains(new GridLocation(8,0)));
        assertTrue(nextLocations.contains(new GridLocation(7,0)));
        assertTrue(nextLocations.contains(new GridLocation(6,0)));
        assertTrue(nextLocations.contains(new GridLocation(6,1)));
        assertTrue(nextLocations.contains(new GridLocation(6,2)));
        assertTrue(nextLocations.contains(new GridLocation(7,2)));
        assertTrue(nextLocations.contains(new GridLocation(8,2)));
        assertTrue(nextLocations.contains(new GridLocation(8,1)));
        assertTrue(nextLocations.contains(new GridLocation(7,1)));
    }


}