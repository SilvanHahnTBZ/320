package finance.transaction;

import finance.exceptions.InvalidTransactionException;

public class TransactionFactory {
    public static Transaction createTransaction(String type, double amount, String category, String date, String description) throws InvalidTransactionException {
        return switch (type.toLowerCase()) {
            case "income" -> new Income(amount, category, date, description);
            case "expense" -> new Expense(amount, category, date, description);
            default -> throw new InvalidTransactionException("Unbekannter Transaktionstyp: " + type);
        };
    }
}