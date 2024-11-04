import java.util.ArrayList;

public class Student {
    private final String name;
    private final ArrayList<Test> tests;

    public Student(String name) {
        this.name = name;
        this.tests = new ArrayList<>();
    }

    public void addTest(Test test) {
        tests.add(test);
    }

    public float getNotenschnitt() {
        if (tests.isEmpty()) {
            return 0;
        }
        float total = 0;
        for (Test test : tests) {
            total += test.calculateGrade();
        }
        return total / tests.size();
    }

    public String getName() {
        return name;
    }
}
