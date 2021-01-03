package exceptionclass.course;

public class Course {

  private String name;
  private SimpleTime begin;

  public Course(String name, SimpleTime begin) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name must be not null!");
    }
    this.name = name;
    if (begin == null) {
      throw new IllegalArgumentException("Begin time must not be null!");
    }
    this.begin = begin;
  }

  public String getName() {
    return name;
  }

  public SimpleTime getBegin() {
    return begin;
  }

  @Override
  public String toString() {
    return begin.toString() + ": " + name;
  }
}
