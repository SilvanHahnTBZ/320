package finance;

import finance.category.Category;
import finance.transaction.Income;
import finance.transaction.Expense;
import finance.exceptions.InvalidTransactionException;
import finance.exceptions.InvalidDateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinanceManagerTest {
    private FinanceManager manager;

    @BeforeEach
    void setUp() {
        // Initialize the singleton instance with a new object for test isolation
        manager = new FinanceManager();
    }

    @Test
    void testAddTransactionAndCalculateTotalBalance() throws InvalidTransactionException, InvalidDateException {
        // Test adding transactions and calculating total balance
        Category salaryCategory = new Category("Gehalt", "Monatliches Einkommen");
        Category rentCategory = new Category("Miete", "Monatliche Mietzahlung");

        manager.addTransaction(new Income(500, salaryCategory, "2023-10-01", "Test Einkommen"));
        manager.addTransaction(new Expense(200, rentCategory, "2023-10-02", "Test Ausgabe"));

        assertEquals(300, manager.calculateTotalBalance(), "Der Gesamtsaldo sollte 300 betragen.");
    }

    @Test
    void testCalculateBalanceByCategory() throws InvalidTransactionException, InvalidDateException {
        // Test calculating balance by category
        Category salaryCategory = new Category("Gehalt", "Monatliches Einkommen");
        Category groceryCategory = new Category("Lebensmittel", "Wocheneinkäufe");
        Category leisureCategory = new Category("Freizeit", "Freizeitaktivitäten");

        manager.addTransaction(new Income(1000, salaryCategory, "2023-10-01", "Monatliches Gehalt"));
        manager.addTransaction(new Expense(200, groceryCategory, "2023-10-02", "Wocheneinkauf"));
        manager.addTransaction(new Expense(300, leisureCategory, "2023-10-03", "Kinobesuch"));

        Map<String, Double> categoryBalances = manager.calculateBalanceByCategory();
        assertEquals(1000, categoryBalances.get("Gehalt"), "Saldo für Gehalt sollte 1000 sein.");
        assertEquals(-200, categoryBalances.get("Lebensmittel"), "Saldo für Lebensmittel sollte -200 sein.");
        assertEquals(-300, categoryBalances.get("Freizeit"), "Saldo für Freizeit sollte -300 sein.");
    }
}
