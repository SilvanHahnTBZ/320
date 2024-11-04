package finance.transaction;

import finance.category.Category;
import finance.exceptions.InvalidTransactionException;
import finance.exceptions.InvalidDateException;

public class TransactionFactory {
    public static Transaction createTransaction(String type, double amount, Category category, String date, String description) throws InvalidTransactionException, InvalidDateException {
        return switch (type.toLowerCase()) {
            case "income" -> new Income(amount, category, date, description);
            case "expense" -> new Expense(amount, category, date, description);
            default -> throw new InvalidTransactionException("Unknown transaction type: " + type);
        };
    }
}
