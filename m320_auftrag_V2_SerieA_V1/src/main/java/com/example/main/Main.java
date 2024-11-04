// Main.java
package com.example.main;

import com.example.stack.*;
import java.util.Scanner;

/**
 * Hauptklasse, um die Medienverwaltung über ein Konsolenmenü zu steuern.
 */
public class Main {
    public static void main(String[] args) {
        MedienVerwaltung verwaltung = new MedienVerwaltung();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Medien Verwaltung Menü:");
            System.out.println("1. Neues Buch hinzufügen");
            System.out.println("2. Neuen Film hinzufügen");
            System.out.println("3. Alle Medien anzeigen");
            System.out.println("4. Nach Medien suchen");
            System.out.println("5. Medien löschen");
            System.out.println("6. Beenden");
            System.out.print("Bitte wählen Sie eine Option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Leere Zeile lesen

            switch (choice) {
                case 1:
                    System.out.print("Titel des Buchs: ");
                    String buchTitel = scanner.nextLine();
                    System.out.print("Autor des Buchs: ");
                    String autor = scanner.nextLine();
                    verwaltung.addMedien(new Buch(buchTitel, autor));
                    break;
                case 2:
                    System.out.print("Titel des Films: ");
                    String filmTitel = scanner.nextLine();
                    System.out.print("Regisseur des Films: ");
                    String regisseur = scanner.nextLine();
                    verwaltung.addMedien(new Film(filmTitel, regisseur));
                    break;
                case 3:
                    System.out.println("Alle Medien:");
                    verwaltung.printMedien();
                    break;
                case 4:
                    System.out.print("Titel des Mediums zum Suchen: ");
                    String suchTitel = scanner.nextLine();
                    Medien gefundeneMedien = verwaltung.sucheMedien(suchTitel);
                    if (gefundeneMedien != null) {
                        gefundeneMedien.printOut();
                    } else {
                        System.out.println("Medium nicht gefunden.");
                    }
                    break;
                case 5:
                    System.out.print("Titel des Mediums zum Löschen: ");
                    String loeschTitel = scanner.nextLine();
                    if (verwaltung.loescheMedien(loeschTitel)) {
                        System.out.println("Medium erfolgreich gelöscht.");
                    } else {
                        System.out.println("Medium nicht gefunden.");
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Programm beendet.");
                    break;
                default:
                    System.out.println("Ungültige Auswahl.");
                    break;
            }
        }

        scanner.close();
    }
}
