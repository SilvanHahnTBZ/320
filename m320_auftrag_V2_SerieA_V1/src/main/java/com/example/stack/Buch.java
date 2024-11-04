// Buch.java
package com.example.stack;

/**
 * Repräsentiert ein Buch als Medium.
 */
public class Buch extends Medien {
    private final String autor;

    /**
     * Konstruktor für ein Buch.
     *
     * @param titel Titel des Buchs
     * @param autor Autor des Buchs
     */
    public Buch(String titel, String autor) {
        super(titel);
        this.autor = autor;
    }

    /**
     * Gibt die Informationen über das Buch aus.
     */
    @Override
    public void printOut() {
        System.out.println("Buch Titel: " + getTitel());
        System.out.println("Autor: " + autor);
    }
}
