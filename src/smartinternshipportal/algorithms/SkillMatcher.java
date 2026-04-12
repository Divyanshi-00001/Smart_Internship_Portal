package smartinternshipportal.algorithms;

import java.util.HashSet;

public class SkillMatcher {
	public static int MatchSkills(HashSet<String> studentSkills, HashSet<String> jobSkills, HashSet<String> nonMatchedSkills) {
		int count = 0;
		for(String skill : jobSkills) {
			if(studentSkills.contains(skill)) {
				count++;
			}
			else {
				nonMatchedSkills.add(skill);
			}
		}
		return count;
	}
}
