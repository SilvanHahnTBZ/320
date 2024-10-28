package finance;

public class FinanceManager {
    private static FinanceManager instance;

    // Private Konstruktor für Singleton Pattern
    private FinanceManager() {
    }

    // Methode zum Zugriff auf die Singleton-Instanz
    public static FinanceManager getInstance() {
        if (instance == null) {
            instance = new FinanceManager();
        }
        return instance;
    }

    // Einstiegspunkt für das Programm
    public static void main(String[] args) {
        System.out.println("Finanzverwaltungssystem gestartet!");
    }
}
