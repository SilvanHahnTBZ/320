// MedienVerwaltung.java
package com.example.stack;

import java.util.ArrayList;

/**
 * Verwaltungsklasse für verschiedene Medien.
 */
public class MedienVerwaltung {
    private final ArrayList<Medien> medienListe;

    /**
     * Konstruktor, der eine neue Medienliste erstellt.
     */
    public MedienVerwaltung() {
        medienListe = new ArrayList<>();
    }

    /**
     * Fügt ein neues Medium zur Verwaltung hinzu.
     *
     * @param medien Das hinzuzufügende Medium
     */
    public void addMedien(Medien medien) {
        medienListe.add(medien);
    }

    /**
     * Gibt alle Medien in der Verwaltung aus.
     */
    public void printMedien() {
        for (Medien medien : medienListe) {
            medien.printOut();
            System.out.println("----------------");
        }
    }

    /**
     * Sucht nach einem Medium anhand des Titels.
     *
     * @param titel Titel des Mediums
     * @return Gefundenes Medium oder null, falls nicht vorhanden
     */
    public Medien sucheMedien(String titel) {
        for (Medien medien : medienListe) {
            if (medien.getTitel().equalsIgnoreCase(titel)) {
                return medien;
            }
        }
        return null;
    }

    /**
     * Löscht ein Medium anhand des Titels.
     *
     * @param titel Titel des zu löschenden Mediums
     * @return true, falls das Medium erfolgreich gelöscht wurde, sonst false
     */
    public boolean loescheMedien(String titel) {
        Medien medien = sucheMedien(titel);
        if (medien != null) {
            medienListe.remove(medien);
            return true;
        }
        return false;
    }
}
