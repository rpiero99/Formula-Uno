package it.unicam.cs.pa2021.formulaUno.model;

/**
 * Enumerazione che descrive i diversi stati in cui pu&ograve; trovarsi un generico angolo.
 * OUT_OF_RACE --> angolo fuori dalla pista nel campo di gioco.
 * IN_RACE --> angolo dentro la pista nel campo di gioco.
 * GOAL --> angolo facente parte del traguardo.
 * STARTING --> angolo scelto per la partenza dei veicoli.
 */
public enum CornerStatus {
    OUT_OF_RACE,
    IN_RACE,
    GOAL,
    STARTING;
}
