package week03d04;

public class PhoneParser {

  public Phone parse(String phoneNumber) {
    String[] parts = phoneNumber.split("-");
    return new Phone(parts[0], parts[1]);
  }

  public static void main(String[] args) {
    PhoneParser pp = new PhoneParser();
    System.out.println(pp.parse("10-1234567"));
  }
}
