package it.unicam.cs.pa2021.formulaUno;

import java.util.Set;

public interface Location<S> {

    /**
     * Dato un veicolo, restituisce l'insieme delle posizioni che potrà avere il veicolo.
     * @param car il veicolo di cui dobbiamo calcolare l'insieme delle posizioni successive.
     * @return restituisce l'insieme delle posizioni che potrà avere il veicolo.
     */
    Set<? extends Location<S>> nextPossibleLocations(Car<S,? extends Location<S>> car);
}
