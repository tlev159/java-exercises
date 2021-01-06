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
      System.out.println(s.getLevel());
      System.out.println(s.getLevel());
      if (s.getName().equals(str)) {
        searchedSkinLevel = s.getLevel();
      }
    }
    return searchedSkinLevel;
  }

  public String separateSkillName(String skill) {
    String addedSkillName = skill.toString().substring(0, skill.length() - 3);
    return addedSkillName;
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
