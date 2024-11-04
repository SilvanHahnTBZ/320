# Finanzverwaltungssystem

## Projektübersicht
Das Finanzverwaltungssystem ist eine CLI-basierte Anwendung zur Verwaltung persönlicher Finanzen. Es ermöglicht Benutzern, Einnahmen und Ausgaben nach Kategorien zu verfolgen, den Gesamtsaldo zu berechnen und die Finanzen anhand von Kategorien zu analysieren. Die Anwendung basiert auf der Java Virtual Machine (JVM) und verwendet eine modulare Architektur, um zukünftige Erweiterungen zu erleichtern.

## Architektur und Design
Das Projekt folgt einem modularen Aufbau mit Verwendung des Singleton-Patterns für die zentrale `FinanceManager`-Klasse und des Factory-Patterns zur Erstellung von Transaktionsobjekten. Zu den Hauptklassen gehören:

- **FinanceManager**: Zentrale Klasse zur Verwaltung aller Transaktionen, Berechnung des Gesamtsaldos und Anzeige von Berichten.
- **Transaction (Interface)**: Definiert grundlegende Methoden für Transaktionen.
- **Income** und **Expense**: Spezifische Klassen für Einnahmen und Ausgaben, die das `Transaction`-Interface implementieren.
- **TransactionFactory**: Eine Factory zur Erstellung von `Income` oder `Expense`-Objekten basierend auf dem Transaktionstyp.
- **Category**: Klasse zur Definition von Kategorien mit `name` und `description`, einschließlich Validierung für leere oder ungültige Namen.
- **Validator**: Utility-Klasse zur Validierung von Transaktionsdaten, einschließlich `amount`, `date` und `description`.
- **InvalidTransactionException** und **InvalidDateException**: Benutzerdefinierte Exceptions für Fehler bei Transaktionen und ungültige Datumsformate.

### Klassendiagramm
![Klassendiagramm](..\src\main\resources\Sequenz-Diagramm-Einnahme-hinzufügen.png)

## Design Patterns
- **Factory Pattern**: Ermöglicht die einfache Erweiterbarkeit um neue Transaktionstypen, ohne Änderungen am Hauptcode der `FinanceManager`-Klasse vorzunehmen.
- **Singleton Pattern**: Die `FinanceManager`-Klasse wird als Singleton implementiert, um eine zentrale Verwaltung aller Transaktionen sicherzustellen.

## Nutzung

1. **Starten der Anwendung**:
   - Führen Sie die `main`-Methode der `FinanceManager`-Klasse aus.

2. **Bedienung über das CLI-Menü**:
   - **1. Einnahme hinzufügen**: Fügt eine neue Einnahme hinzu.
   - **2. Ausgabe hinzufügen**: Fügt eine neue Ausgabe hinzu.
   - **3. Gesamtsaldo anzeigen**: Zeigt den aktuellen Gesamtsaldo basierend auf allen Transaktionen an.
   - **4. Saldos nach Kategorie anzeigen**: Zeigt die Salden gruppiert nach Kategorien an.
   - **5. Beenden**: Beendet die Anwendung.

