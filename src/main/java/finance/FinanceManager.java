package finance;

import finance.category.Category;
import finance.transaction.Transaction;
import finance.transaction.TransactionFactory;
import finance.exceptions.InvalidTransactionException;
import finance.exceptions.InvalidDateException;
import finance.transaction.Income;
import finance.transaction.Expense;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FinanceManager {
    private static FinanceManager instance;
    private final List<Transaction> transactions;

    FinanceManager() {
        this.transactions = new ArrayList<>();
    }

    public static FinanceManager getInstance() {
        if (instance == null) {
            instance = new FinanceManager();
        }
        return instance;
    }

    public void addTransaction(Transaction transaction) {
        try {
            if (transaction.getAmount() <= 0) {
                throw new InvalidTransactionException("Transaction amount must be positive.");
            }
            transactions.add(transaction);
            System.out.println("Transaction added: " + transaction.getDescription());
        } catch (InvalidTransactionException e) {
            System.out.println("Error adding transaction: " + e.getMessage());
        }
    }

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

    public void printBalance() {
        System.out.println("Current balance: " + calculateTotalBalance());
    }

    public Map<String, Double> calculateBalanceByCategory() {
        Map<String, Double> categoryBalances = new HashMap<>();
        for (Transaction transaction : transactions) {
            String categoryName = transaction.getCategory().getName();
            double amount = transaction instanceof Income ? transaction.getAmount() : -transaction.getAmount();
            categoryBalances.put(categoryName, categoryBalances.getOrDefault(categoryName, 0.0) + amount);
        }
        return categoryBalances;
    }

    public void printBalanceByCategory() {
        Map<String, Double> categoryBalances = calculateBalanceByCategory();
        System.out.println("Balance by category:");
        for (Map.Entry<String, Double> entry : categoryBalances.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void startCLI() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nFinance Management System");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. Show Total Balance");
            System.out.println("4. Show Balance by Category");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addTransactionWithValidation(scanner, "income");
                case 2 -> addTransactionWithValidation(scanner, "expense");
                case 3 -> printBalance();
                case 4 -> printBalanceByCategory();
                case 5 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private void addTransactionWithValidation(Scanner scanner, String type) {
        try {
            System.out.print("Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Category Name: ");
            String categoryName = scanner.nextLine();
            System.out.print("Category Description: ");
            String categoryDescription = scanner.nextLine();
            Category category = new Category(categoryName, categoryDescription);
            System.out.print("Date (yyyy-MM-dd): ");
            String date = scanner.nextLine();
            System.out.print("Description: ");
            String description = scanner.nextLine();
            Transaction transaction = TransactionFactory.createTransaction(type, amount, category, date, description);
            addTransaction(transaction);
        } catch (InvalidTransactionException | InvalidDateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FinanceManager manager = FinanceManager.getInstance();
        manager.startCLI();
    }
}
