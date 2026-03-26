package smartinternshipportal.algorithms;

import java.util.HashSet;

public class SkillMatcher {
	public static int MatchSkills(HashSet<String> jobSkills, HashSet<String> studentSkills) {
		int count = 0;
		for(String skill : studentSkills) {
			if(jobSkills.contains(skill)) {
				count++;
			}
		}
		return count;
	}
}
