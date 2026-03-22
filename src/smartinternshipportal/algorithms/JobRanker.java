package smartinternshipportal.algorithms;

import smartinternshipportal.model.Job;

import java.util.*;

public class JobRanker {

    public static List<Job> rankJobs(HashMap<Job, Double> jobScores) {

        PriorityQueue<Map.Entry<Job, Double>> pq =
                new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));

        pq.addAll(jobScores.entrySet());

        List<Job> rankedJobs = new ArrayList<>();

        while (!pq.isEmpty()) {
            rankedJobs.add(pq.poll().getKey());
        }

        return rankedJobs;
    }
}