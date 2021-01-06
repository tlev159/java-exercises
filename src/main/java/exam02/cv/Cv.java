package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

  private String name;

  List<Skill> skills = new ArrayList<>();

  public Cv(String name, List<Skill> skills) {
    this.name = name;
    this.skills = skills;
  }

  public void addSkills(String... skills1) {
    for (String s:skills1) {
      String skillName = separateSkillName(s);
      int skillLevel = separateSkillLevel(s);
      skills.add(new Skill(skillName, skillLevel));
    }
  }

  public int findSkillLevelByName(String str) {
    int searchedSkinLevel = 0;
    for (Skill s: skills) {
      if (s.getName().equals(str)) {
        searchedSkinLevel = s.getLevel();
      }
    }
    if (searchedSkinLevel == 0) {
      throw new SkillNotFoundException("Skill not found");
    }
    return searchedSkinLevel;
  }

  public String separateSkillName(String skill) {
    String addedSkillName = skill.substring(0, skill.length() - 3);
    return addedSkillName.trim();
  }

  public int separateSkillLevel(String skill) {
    String level = skill.toString().substring(skill.length() - 2, skill.length() - 1);
    return Integer.parseInt(level);
  }

  public Cv(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<Skill> getSkills() {
    return skills;
  }

}
