package introjuit;

public class Gentleman {

  public String sayHello(String name) {
    if (name == null) {
      return "Hello Anonymus";
    }
    return "Hello " + name;
  }
}
