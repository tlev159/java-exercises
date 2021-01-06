package exam02.cv;

public class SkillNotFoundException extends RuntimeException {
  private String name;

  public SkillNotFoundException(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
