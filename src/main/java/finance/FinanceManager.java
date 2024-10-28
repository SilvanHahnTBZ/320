package finance;

import finance.transaction.Transaction;
import finance.transaction.Income;
import finance.transaction.Expense;
import finance.exceptions.InvalidTransactionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinanceManager {
    private static FinanceManager instance;
    private List<Transaction> transactions;

    // Private Konstruktor für Singleton Pattern
    private FinanceManager() {
        this.transactions = new ArrayList<>();
    }

    // Methode zum Zugriff auf die Singleton-Instanz
    public static FinanceManager getInstance() {
        if (instance == null) {
            instance = new FinanceManager();
        }
        return instance;
    }

    // Methode zum Hinzufügen einer Transaktion mit Fehlerbehandlung
    public void addTransaction(Transaction transaction) {
        try {
            if (transaction.getAmount() <= 0) {
                throw new InvalidTransactionException("Transaktionsbetrag muss positiv sein.");
            }
            transactions.add(transaction);
            System.out.println("Transaktion hinzugefügt: " + transaction.getDescription());
        } catch (InvalidTransactionException e) {
            System.out.println("Fehler beim Hinzufügen der Transaktion: " + e.getMessage());
        }
    }

    // Methode zur Berechnung des Gesamtsaldos
    public double calculateTotalBalance() {
        double totalBalance = 0.0;
        for (Transaction transaction : transactions) {
            if (transaction instanceof Income) {
                totalBalance += transaction.getAmount();
            } else if (transaction instanceof Expense) {
                totalBalance -= transaction.getAmount();
            }
        }
        return totalBalance;
    }

    // Methode zur Ausgabe des aktuellen Gesamtsaldos
    public void printBalance() {
        System.out.println("Aktueller Saldo: " + calculateTotalBalance());
    }

    // Methode zur Berechnung des Saldos pro Kategorie
    public Map<String, Double> calculateBalanceByCategory() {
        Map<String, Double> categoryBalances = new HashMap<>();

        for (Transaction transaction : transactions) {
            String category = transaction.getCategory();
            double amount = transaction instanceof Income ? transaction.getAmount() : -transaction.getAmount();

            categoryBalances.put(category, categoryBalances.getOrDefault(category, 0.0) + amount);
        }

        return categoryBalances;
    }

    // Methode zur Ausgabe des Saldos pro Kategorie
    public void printBalanceByCategory() {
        Map<String, Double> categoryBalances = calculateBalanceByCategory();
        System.out.println("Saldo nach Kategorie:");
        for (Map.Entry<String, Double> entry : categoryBalances.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Beispielhafte Verwendung der Klasse im main-Programm
    public static void main(String[] args) {
        FinanceManager manager = FinanceManager.getInstance();

        try {
            // Beispielhafte Transaktionen
            manager.addTransaction(new Income(5000, "Gehalt", "2023-10-01", "Monatliches Gehalt"));
            manager.addTransaction(new Expense(1500, "Miete", "2023-10-02", "Monatliche Miete"));
            manager.addTransaction(new Expense(300, "Lebensmittel", "2023-10-03", "Wocheneinkauf"));
        } catch (InvalidTransactionException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // Gesamt-Saldo anzeigen
        manager.printBalance();

        // Saldos nach Kategorie anzeigen
        manager.printBalanceByCategory();
    }
}