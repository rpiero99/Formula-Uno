package it.unicam.cs.pa2021.formulaUno;

import java.util.Set;

/**
 * Interfaccia che descrive cosa deve fare generica locazione in un GameField.
 */
public interface Location {

    /**
     * Dato un veicolo, restituisce l'insieme delle posizioni che potrà avere il veicolo.
     * @param car il veicolo di cui dobbiamo calcolare l'insieme delle posizioni successive.
     * @return restituisce l'insieme delle posizioni che potrà avere il veicolo.
     */
    Set<Location> nextPossibleLocations(Car car);
}
