package smartinternshipportal.algorithms;

import java.util.HashSet;

public class SkillMatcher {

    public static int matchSkills(HashSet<String> studentSkills, HashSet<String> jobSkills) {

        int matches = 0;

        for (String skill : studentSkills) {
            if (jobSkills.contains(skill)) {
                matches++;
            }
        }

        return matches;
    }
}