package finance.category;

public class Category {
    private final String name;
    private final String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Category{name='" + name + "', description='" + description + "'}";
    }
}