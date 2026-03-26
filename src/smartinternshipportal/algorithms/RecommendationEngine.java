package smartinternshipportal.algorithms;

import smartinternshipportal.model.*;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class RecommendationEngine {
	private int match;
	private double score;	
	public class Recommendation {
		private Company co;
		private Job job;
		private double score;
		
		public Recommendation(Company co, Job job, double score) {
			this.co = co;
			this.job = job;
			this.score = score;
		}
		
		public double getScore() {
	        return score;
	    }
	}	
	private List<Recommendation> scoreMap = new ArrayList<>(); 
	
	public void recommend(HashSet<Company> companies, Student stu) {
		for(Company c : companies) {
			HashSet<Job> jobs = c.getJobs();
			for(Job job : jobs) {
				match = SkillMatcher.MatchSkills(job.getRequiredSkills(),stu.getSkills());
				score = ScoreCalculator.calculateScore(match,job.getRequiredSkills().size(),stu.getCgpa(),job.getSalary(),stu.getSalary());
				scoreMap.add(new Recommendation(c,job,score));
			}
		}
		scoreMap = JobRanker.rankJobs(scoreMap);
		show();
	}
	
	void show() {
		for(Recommendation j : scoreMap) {
			System.out.println(j.score);
			j.co.show();
			j.job.show();
		}
	}
}