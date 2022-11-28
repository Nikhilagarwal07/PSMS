import java.util.*;

public class FinalYear extends Student {
    ArrayList<String> skills;

    public FinalYear(String name, String id, String branch, float cgpa, String location, PreferenceOrder preferenceOrder, ArrayList<String> skills) {
        super(name, id, branch, cgpa, location, preferenceOrder);
        this.skills = skills;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public void removeSkill(String skill) {
        this.skills.remove(skill);
    }
}
