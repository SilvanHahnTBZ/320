package finance;

import finance.transaction.Income;
import finance.transaction.Expense;
import finance.exceptions.InvalidTransactionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FinanceManagerTest {
    private FinanceManager manager;

    @BeforeEach
    void setUp() {
        manager = FinanceManager.getInstance();
    }

    @Test
    void testAddTransactionAndCalculateTotalBalance() throws InvalidTransactionException {
        // Teste Hinzufügen und Gesamtsaldo
        manager.addTransaction(new Income(500, "Gehalt", "2023-10-01", "Test Einkommen"));
        manager.addTransaction(new Expense(200, "Miete", "2023-10-02", "Test Ausgabe"));

        assertEquals(300, manager.calculateTotalBalance(), "Der Gesamtsaldo sollte 300 betragen.");
    }

    @Test
    void testCalculateBalanceByCategory() throws InvalidTransactionException {
        // Teste Kategorieberechnung
        manager.addTransaction(new Income(1000, "Gehalt", "2023-10-01", "Monatliches Gehalt"));
        manager.addTransaction(new Expense(200, "Lebensmittel", "2023-10-02", "Wocheneinkauf"));
        manager.addTransaction(new Expense(300, "Freizeit", "2023-10-03", "Kinobesuch"));

        Map<String, Double> categoryBalances = manager.calculateBalanceByCategory();
        assertEquals(1000, categoryBalances.get("Gehalt"), "Saldo für Gehalt sollte 1000 sein.");
        assertEquals(-200, categoryBalances.get("Lebensmittel"), "Saldo für Lebensmittel sollte -200 sein.");
        assertEquals(-300, categoryBalances.get("Freizeit"), "Saldo für Freizeit sollte -300 sein.");
    }
}