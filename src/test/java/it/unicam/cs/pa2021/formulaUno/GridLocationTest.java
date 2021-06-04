package it.unicam.cs.pa2021.formulaUno;

import junit.framework.TestCase;

import java.util.Set;

public class GridLocationTest extends TestCase {

    public void testNextPossibleLocations() {
        GridLocation firstLoc = new GridLocation(4,11);
        Car<CornerStatus,GridLocation> car= new SimpleCar(null,new BasicGameField(40,40),firstLoc);
        car.moveToNewLocation(new GridLocation(5,9));
    }

    public void testGetAdjacentLocations() {
        GridLocation gridLocation = new GridLocation(3,3);
        Set<GridLocation> adjacents = gridLocation.getAdjacentLocations(5,4);
        for (GridLocation a: adjacents) {
            System.out.println(a.getColumn() + " " + a.getRow());
        }
    }

}