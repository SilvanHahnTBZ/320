package finance;

import finance.transaction.Transaction;
import finance.transaction.TransactionFactory;
import finance.transaction.Income;
import finance.transaction.Expense;
import finance.exceptions.InvalidTransactionException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FinanceManager {
    private static FinanceManager instance;
    private final List<Transaction> transactions;

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

    // Methode zum Starten der Benutzeroberfläche
    public void startCLI() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nFinanzverwaltungssystem");
            System.out.println("1. Einnahme hinzufügen");
            System.out.println("2. Ausgabe hinzufügen");
            System.out.println("3. Gesamtsaldo anzeigen");
            System.out.println("4. Saldos nach Kategorie anzeigen");
            System.out.println("5. Beenden");
            System.out.print("Wähle eine Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Nach Zeilenumbruch lesen

            switch (choice) {
                case 1 -> addIncome(scanner);
                case 2 -> addExpense(scanner);
                case 3 -> printBalance();
                case 4 -> printBalanceByCategory();
                case 5 -> exit = true;
                default -> System.out.println("Ungültige Option. Bitte versuche es erneut.");
            }
        }
        scanner.close();
    }

    // Methode zum Hinzufügen einer Einnahme über die Factory
    private void addIncome(Scanner scanner) {
        try {
            System.out.print("Betrag: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Zeilenumbruch einlesen
            System.out.print("Kategorie: ");
            String category = scanner.nextLine();
            System.out.print("Datum (yyyy-mm-dd): ");
            String date = scanner.nextLine();
            System.out.print("Beschreibung: ");
            String description = scanner.nextLine();

            Transaction income = TransactionFactory.createTransaction("income", amount, category, date, description);
            addTransaction(income);
        } catch (InvalidTransactionException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    // Methode zum Hinzufügen einer Ausgabe über die Factory
    private void addExpense(Scanner scanner) {
        try {
            System.out.print("Betrag: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Zeilenumbruch einlesen
            System.out.print("Kategorie: ");
            String category = scanner.nextLine();
            System.out.print("Datum (yyyy-mm-dd): ");
            String date = scanner.nextLine();
            System.out.print("Beschreibung: ");
            String description = scanner.nextLine();

            Transaction expense = TransactionFactory.createTransaction("expense", amount, category, date, description);
            addTransaction(expense);
        } catch (InvalidTransactionException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    // Hauptprogramm zur Ausführung der CLI
    public static void main(String[] args) {
        FinanceManager manager = FinanceManager.getInstance();
        manager.startCLI();
    }
}
