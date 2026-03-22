package smartinternshipportal.algorithms;

import smartinternshipportal.model.Job;
import smartinternshipportal.model.Student;

import java.util.*;

public class RecommendationEngine {

    public static List<Job> recommendJobs(Student student, List<Job> jobs) {
        HashMap<Job, Double> jobScores = new HashMap<>();
        
        for (Job job : jobs) {
            int matches = SkillMatcher.matchSkills( student.getSkills(), job.getRequiredSkills() );
            double score = ScoreCalculator.calculateScore( matches, student.getCgpa() );
            jobScores.put(job, score);
        }

        return JobRanker.rankJobs(jobScores);
    }
}