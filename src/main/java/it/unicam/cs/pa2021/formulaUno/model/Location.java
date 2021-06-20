package it.unicam.cs.pa2021.formulaUno.model;

import java.util.Set;

public interface Location {

    /**
     * Dato un veicolo, restituisce l'insieme delle posizioni che potrà avere il veicolo.
     * @param car il veicolo di cui dobbiamo calcolare l'insieme delle posizioni successive.
     * @param field il game field nel quale si trova il veicolo.
     * @return restituisce l'insieme delle posizioni che potrà avere il veicolo.
     */
    Set<? extends Location> nextPossibleLocations(Car<? extends Location> car, GameField<? extends Location> field);
}
