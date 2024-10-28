package finance;

import finance.transaction.Transaction;
import finance.transaction.Income;
import finance.transaction.Expense;
import java.util.ArrayList;
import java.util.List;

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

    // Methode zum Hinzufügen einer Transaktion
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("Transaktion hinzugefügt: " + transaction.getDescription());
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

    // Beispielausgabe des Saldos
    public void printBalance() {
        System.out.println("Aktueller Saldo: " + calculateTotalBalance());
    }

    public static void main(String[] args) {
        FinanceManager manager = FinanceManager.getInstance();
        manager.printBalance();
    }
}
