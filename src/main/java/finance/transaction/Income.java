package finance.transaction;

import finance.category.Category;
import finance.exceptions.InvalidTransactionException;
import finance.exceptions.InvalidDateException;
import finance.utils.Validator;

public class Income implements Transaction {
    private final double amount;
    private final Category category;
    private final String date;
    private final String description;

    public Income(double amount, Category category, String date, String description) throws InvalidTransactionException, InvalidDateException {
        Validator.validateAmount(amount);
        Validator.validateDate(date);
        Validator.validateDescription(description);

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
    public Category getCategory() {
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

    @Override
    public String toString() {
        return "Income{" +
                "amount=" + amount +
                ", category=" + category +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
