package smartinternshipportal.algorithms;

public class ScoreCalculator {

    public static double calculateScore(int skillMatch, double cgpa) {

        return (skillMatch * 0.6) + (cgpa * 0.4);
    }
}