package week03d04;

public class Phone {

  private String prefix;
  private String number;

  public Phone(String prefix, String number) {
    this.prefix = prefix;
    this.number = number;
  }

  public String getPrefix() {
    return prefix;
  }

  public String getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return "Phone{" +
            "prefix='" + prefix + '\'' +
            ", number='" + number + '\'' +
            '}';
  }
}
