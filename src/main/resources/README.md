# Finanzverwaltungssystem

## Projektübersicht
Dieses Projekt ist ein einfaches Finanzverwaltungssystem, das es dem Benutzer ermöglicht, Einnahmen und Ausgaben zu verwalten, den Gesamtsaldo zu berechnen und die Finanzen nach Kategorien zu analysieren. Die Anwendung basiert auf der Java Virtual Machine (JVM) und verwendet ein Kommandozeilen-Interface (CLI).

## Architektur und Design
Das Projekt ist modular aufgebaut und verwendet das Singleton Pattern für die zentrale `FinanceManager` Klasse und das Factory Pattern für die Erstellung von Transaktionsobjekten.

### Klassendiagramm
![Klassendiagramm](./src/main/resources/Sequenz-Diagramm-Einnahme-hinzufügen.png)

### Klassenübersicht
- **FinanceManager**: Zentrale Klasse, die alle Transaktionen verwaltet, den Gesamtsaldo berechnet und Berichte anzeigt.
- **Transaction (Interface)**: Definiert grundlegende Methoden für Transaktionen.
- **Income und Expense**: Spezifische Klassen für Einnahmen und Ausgaben, die `Transaction` implementieren.
- **TransactionFactory**: Eine Factory, die `Income` oder `Expense` Objekte basierend auf dem Transaktionstyp erstellt.
- **InvalidTransactionException**: Benutzerdefinierte Exception, die bei ungültigen Transaktionen ausgelöst wird.

### Design Pattern
Das Factory Pattern wurde für die Erstellung der Transaktionen verwendet. Der Grund dafür ist, dass das Projekt in Zukunft leicht um weitere Transaktionstypen erweitert werden kann, ohne den Hauptcode in der `FinanceManager` Klasse anpassen zu müssen.

## Nutzung
1. Starte das Programm über die `main` Methode in der `FinanceManager` Klasse.
2. Folge den Anweisungen im CLI-Menü:
    - Einnahmen und Ausgaben hinzufügen
    - Gesamtsaldo anzeigen
    - Saldos nach Kategorie anzeigen
