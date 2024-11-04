public class Test {
    private final int points;
    private final int totalPoints;

    public Test(int points, int totalPoints) {
        this.points = points;
        this.totalPoints = totalPoints;
    }

    public float calculateGrade() {
        return points * 5f / totalPoints + 1;
    }

    public int getPoints() {
        return points;
    }
}
