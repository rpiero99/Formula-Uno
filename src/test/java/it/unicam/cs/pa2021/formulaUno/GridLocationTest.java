package it.unicam.cs.pa2021.formulaUno;

import it.unicam.cs.pa2021.formulaUno.model.*;
import junit.framework.TestCase;

import java.util.Set;

public class GridLocationTest extends TestCase {

    public void testNextPossibleLocations() {
        GridLocation firstLoc = new GridLocation(8,2);
        Player<GridLocation> player = new BotPlayer("Arfonso", new BasicGameField(10,20,new boolean[20][10]),firstLoc);
        Car<GridLocation> car= player.getCar();
        car.moveToNewLocation(new GridLocation(6,4));
        Set<GridLocation> nextLocations = car.getCurrentLocation().nextPossibleLocations(car);
        assertTrue(nextLocations.contains(new GridLocation(3,5)));
        assertTrue(nextLocations.contains(new GridLocation(3,6)));
        assertTrue(nextLocations.contains(new GridLocation(3,7)));
        assertTrue(nextLocations.contains(new GridLocation(4,7)));
        assertTrue(nextLocations.contains(new GridLocation(5,7)));
        assertTrue(nextLocations.contains(new GridLocation(5,6)));
        assertTrue(nextLocations.contains(new GridLocation(5,5)));
        assertTrue(nextLocations.contains(new GridLocation(4,5)));
        assertTrue(nextLocations.contains(new GridLocation(4,6)));
    }


}