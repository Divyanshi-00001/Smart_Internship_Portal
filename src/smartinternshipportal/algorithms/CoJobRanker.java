package smartinternshipportal.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import smartinternshipportal.model.Job;
import smartinternshipportal.model.Student;

public class CoJobRanker {
	public static List<Map.Entry<Student, Double>> rankJobs(Map<Student, Double> scoreMap) {
	    List<Map.Entry<Student, Double>> list = new ArrayList<>(scoreMap.entrySet());

	    list.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

//	    List<Student> result = new ArrayList<>();
//	    for (Map.Entry<Student, Double> entry : list) {
//	        result.add(entry.getKey());
//	    }
	    return list;
	}
}

