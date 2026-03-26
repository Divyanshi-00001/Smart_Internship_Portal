package smartinternshipportal.algorithms;

public class ScoreCalculator {
	public static double calculateScore(int match, int TotalSkills, double cgpa, double salary, double expSalary) {
		double skillScore = (match/TotalSkills)*100;
		double cgpaScore = (cgpa/10)*100;
		double salScore = (salary/expSalary)*100;
		return ((skillScore*0.6)+(cgpaScore*0.2)+(salScore*0.2));
	}
}
