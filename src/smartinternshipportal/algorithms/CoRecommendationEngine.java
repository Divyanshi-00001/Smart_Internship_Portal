package smartinternshipportal.algorithms;

import smartinternshipportal.model.*;
import java.util.*;

public class CoRecommendationEngine {
    public static List<Student> recommendJobs(Job job, List<Student> Students) {
        Map<Student, Double> scoreMap = new HashMap<>();

        for (Student student : Students) {
            int match = SkillMatcher.MatchSkills(student.getSkills(), job.getRequiredSkills());
            double score = ScoreCalculator.calculateScore( match,job.getRequiredSkills().size(),student.getCgpa(), job.getMinCgpa(),job.getSalary(),student.getSalary());
            scoreMap.put(student, score);
        }

        return CoJobRanker.rankJobs(scoreMap);
    }
}