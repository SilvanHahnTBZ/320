import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        Class schoolClass = new Class();

        // Drei Studenten zur Klasse hinzufügen
        for (int i = 0; i < 3; i++) {
            System.out.print("Geben Sie den Namen des Studenten ein: ");
            String name = scanner.nextLine();
            Student student = new Student(name);
            schoolClass.addStudent(student);

            // Drei Tests für jeden Studenten hinzufügen
            for (int j = 0; j < 3; j++) {
                int points = -1;
                int totalPoints = -1;

                // Punktzahl eingeben und validieren
                while (points < 0) {
                    System.out.print("Geben Sie die Punktzahl für Test " + (j + 1) + " ein (keine negativen Werte): ");
                    points = scanner.nextInt();
                    if (points < 0) {
                        System.out.println("Fehler: Punktzahl darf nicht negativ sein.");
                    }
                }

                // Gesamtpunktzahl eingeben und validieren
                while (totalPoints < 0) {
                    System.out.print("Geben Sie die Gesamtpunktzahl für diesen Test ein (keine negativen Werte): ");
                    totalPoints = scanner.nextInt();
                    if (totalPoints < 0) {
                        System.out.println("Fehler: Die Gesamtpunktzahl darf nicht negativ sein.");
                    }
                }

                // Überprüfen, dass die Punktzahl nicht größer ist als die Gesamtpunktzahl
                while (points > totalPoints) {
                    System.out.println("Fehler: Die Punktzahl darf nicht größer sein als die Gesamtpunktzahl.");
                    System.out.print(
                            "Geben Sie die Punktzahl erneut ein (muss kleiner oder gleich der Gesamtpunktzahl sein): ");
                    points = scanner.nextInt();
                }
                scanner.nextLine(); // Für den Scanner-Puffer

                // Test zum Studenten hinzufügen
                Test test = new Test(points, totalPoints);
                student.addTest(test);
            }
        }

        // Notendurchschnitt für jeden Studenten und für die Klasse anzeigen
        System.out.println("Notendurchschnitt pro Student:");
        for (Student student : schoolClass.students) {
            System.out.println(student.getName() + ": " + student.getNotenschnitt());
        }

        System.out.println("Notendurchschnitt der Klasse: " + schoolClass.getAverage());
    }
}
