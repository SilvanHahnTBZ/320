package finance.transaction;

public interface Transaction {
    double getAmount();               // Betrag der Transaktion
    String getCategory();             // Kategorie der Transaktion (z.B. Gehalt, Lebensmittel)
    String getDate();                 // Datum der Transaktion
    String getDescription();          // Beschreibung der Transaktion (optional)
}
