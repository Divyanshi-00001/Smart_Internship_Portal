package smartinternshipportal.algorithms;

import smartinternshipportal.model.*;
import java.util.*;

public class RecommendationEngine {
    public static List<Map.Entry<Job, Double>> recommendJobs(Student student, List<Job> jobs) {
        Map<Job, Double> scoreMap = new HashMap<>();

        for (Job job : jobs) {
            int match = SkillMatcher.MatchSkills(student.getSkills(), job.getRequiredSkills());
            double score = ScoreCalculator.calculateScore( match,job.getRequiredSkills().size(),student.getCgpa(), job.getMinCgpa(),job.getSalary(),student.getSalary());
            scoreMap.put(job, score);
        }

        return JobRanker.rankJobs(scoreMap);
    }
}