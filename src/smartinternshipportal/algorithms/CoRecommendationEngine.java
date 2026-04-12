package smartinternshipportal.algorithms;

import smartinternshipportal.model.*;
import java.util.*;

public class CoRecommendationEngine {
    public static List<Map.Entry<Student, Double>> recommendJobs(Job job, List<Student> Students, HashSet<String> nonMatchedSkills) {
        Map<Student, Double> scoreMap = new HashMap<>();

        for (Student student : Students) {
            int match = SkillMatcher.MatchSkills(student.getSkills(), job.getRequiredSkills(), nonMatchedSkills);
            double score = ScoreCalculator.calculateScore( match,job.getRequiredSkills().size(),student.getQualification(), job.getQualification(),student.getCgpa(), job.getMinCgpa(),job.getSalary(),student.getSalary());
            scoreMap.put(student, score);
        }

        return CoJobRanker.rankJobs(scoreMap);
    }
}