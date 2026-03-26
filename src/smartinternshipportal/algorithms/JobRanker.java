package smartinternshipportal.algorithms;

import java.util.List;

public class JobRanker {
	public static List<RecommendationEngine.Recommendation> rankJobs(List<RecommendationEngine.Recommendation> scoreMap) {
		scoreMap.sort((a, b) -> Double.compare(b.getScore(), a.getScore())); // rank by score
		return scoreMap;
	}
}