package finance.transaction;

import finance.exceptions.InvalidTransactionException;

public class Expense implements Transaction {
    private final double amount;
    private final String category;
    private final String date;
    private final String description;

    public Expense(double amount, String category, String date, String description) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Ausgabenbetrag muss positiv sein.");
        }
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public String getDescription() {
        return description;
    }
}