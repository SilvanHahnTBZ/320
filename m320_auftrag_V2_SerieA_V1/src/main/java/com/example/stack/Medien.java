// Medien.java
package com.example.stack;

/**
 * Abstrakte Klasse, die als Basis für verschiedene Medientypen dient.
 */
public abstract class Medien {
    private final String titel;

    /**
     * Konstruktor für ein Medium.
     *
     * @param titel Titel des Mediums
     */
    public Medien(String titel) {
        this.titel = titel;
    }

    /**
     * Abstrakte Methode, um die Informationen eines Mediums auszugeben.
     */
    public abstract void printOut();

    /**
     * Gibt den Titel des Mediums zurück.
     *
     * @return Titel des Mediums
     */
    public String getTitel() {
        return titel;
    }
}
