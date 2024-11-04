// Film.java
package com.example.stack;

/**
 * Repräsentiert einen Film als Medium.
 */
public class Film extends Medien {
    private final String regisseur;

    /**
     * Konstruktor für einen Film.
     *
     * @param titel     Titel des Films
     * @param regisseur Regisseur des Films
     */
    public Film(String titel, String regisseur) {
        super(titel);
        this.regisseur = regisseur;
    }

    /**
     * Gibt die Informationen über den Film aus.
     */
    @Override
    public void printOut() {
        System.out.println("Film Titel: " + getTitel());
        System.out.println("Regisseur: " + regisseur);
    }
}
