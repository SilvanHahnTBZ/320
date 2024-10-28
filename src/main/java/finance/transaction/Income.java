package finance.transaction;

import finance.exceptions.InvalidTransactionException;

public class Income implements Transaction {
    private double amount;
    private String category;
    private String date;
    private String description;

    public Income(double amount, String category, String date, String description) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Einnahmebetrag muss positiv sein.");
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