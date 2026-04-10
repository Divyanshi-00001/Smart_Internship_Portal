package smartinternshipportal.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import smartinternshipportal.model.Job;

public class JobRanker {
	public static List<Job> rankJobs(Map<Job, Double> scoreMap) {
	    List<Map.Entry<Job, Double>> list = new ArrayList<>(scoreMap.entrySet());

	    list.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

	    List<Job> result = new ArrayList<>();
	    for (Map.Entry<Job, Double> entry : list) {
	        result.add(entry.getKey());
	    }
	    return result;
	}
}

