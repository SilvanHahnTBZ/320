package finance.transaction;

import finance.category.Category;

public interface Transaction {
    double getAmount();
    Category getCategory();
    String getDate();
    String getDescription();
}
