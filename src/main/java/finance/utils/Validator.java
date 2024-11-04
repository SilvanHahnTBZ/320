package finance.utils;

import finance.exceptions.InvalidDateException;
import finance.exceptions.InvalidTransactionException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validator {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static void validateAmount(double amount) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Transaction amount must be positive.");
        }
    }

    public static void validateDate(String date) throws InvalidDateException {
        try {
            DATE_FORMAT.setLenient(false);
            DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new InvalidDateException("Invalid date format. Please use yyyy-MM-dd.");
        }
    }

    public static void validateDescription(String description) throws InvalidTransactionException {
        if (description == null || description.trim().isEmpty()) {
            throw new InvalidTransactionException("Description cannot be empty.");
        }
    }
}
