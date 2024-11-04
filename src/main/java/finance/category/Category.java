package finance.category;

public record Category(String name, String description) {
    public Category {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be null or empty.");
        }
    }

    @Override
    public String toString() {
        return "Category{name='" + name + "', description='" + description + "'}";
    }

    public String getName() {
        return name;
    }
}
