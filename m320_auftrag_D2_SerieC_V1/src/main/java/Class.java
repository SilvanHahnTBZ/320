import java.util.ArrayList;

public class Class {
    ArrayList<Student> students;

    public Class() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public float getAverage() {
        if (students.isEmpty()) {
            return 0;
        }
        float total = 0;
        for (Student student : students) {
            total += student.getNotenschnitt();
        }
        return total / students.size();
    }
}
