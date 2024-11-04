public class TimeTest {
    public static void main(String[] args) {
        // Create a Time object
        Time time = new Time(23, 59, 59);

        // Test toString
        System.out.println("Initial time: " + time);

        // Test nextSecond()
        time.nextSecond();
        System.out.println("After nextSecond(): " + time);

        // Test cascading nextSecond()
        time.nextSecond().nextSecond().nextSecond();
        System.out.println("After three more nextSecond() calls: " + time);

        // Test setTime()
        time.setTime(12, 30, 45);
        System.out.println("After setTime(12, 30, 45): " + time);

        // Test invalid inputs
        try {
            time.setHour(25);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for invalid hour: " + e.getMessage());
        }

        try {
            time.setMinute(61);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for invalid minute: " + e.getMessage());
        }

        try {
            time.setSecond(61);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for invalid second: " + e.getMessage());
        }
    }
}
