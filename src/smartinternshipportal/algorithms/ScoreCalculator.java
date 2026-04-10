package smartinternshipportal.algorithms;

public class ScoreCalculator {
	public static double calculateScore(int match, int TotalSkills, double cgpa, double minCgpa, double salary, double expSalary) {
		double skillScore = (match/TotalSkills)*100.00;
		double cgpaScore = (cgpa/10)*100.00;
		double salScore = (salary/expSalary)*100.00;
		if(cgpa<minCgpa) return 0.0;
		else return ((skillScore*0.6)+(cgpaScore*0.2)+(salScore*0.2));
	}
}
