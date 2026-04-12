package smartinternshipportal.algorithms;

public class ScoreCalculator {
	public static double calculateScore(int match, int totalSkills, String qualification, String qualificationReq, double cgpa, double minCgpa, double salary, double expSalary) {
        
        double skillScore = ((double) match / totalSkills) * 100.0;
        double cgpaScore = (cgpa / 10.0) * 100.0;
        double salScore = (expSalary == 0) ? 0 : Math.min((salary / expSalary) * 100.0, 100);
        if (!qualification.equalsIgnoreCase(qualificationReq)) {
            return 0.0;
        }
        if (cgpa < minCgpa) {
            return 0.0;
        }
        return (skillScore * 0.6) + (cgpaScore * 0.2) + (salScore * 0.2);
    }
}