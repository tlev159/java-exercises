package week02d02;

import java.util.Scanner;

public class Phone {

  private String type;
  private int mem;

  public Phone(String type, int mem) {
    this.type = type;
    this.mem = mem;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getMem() {
    return mem;
  }

  public void setMem(int mem) {
    this.mem = mem;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Phone phone1 = new Phone("Samsung", 16);
    Phone phone2 = new Phone("Xiaomi", 32);

    System.out.println("Kérem a 3. telefon típusát: ");
    String phoneType3 = scanner.nextLine();
    System.out.println("Kérem a 3. telefon memóriájának méretét:");
    int phoneMem3 = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Kérem a 4. telefon típusát: ");
    String phoneType4 = scanner.nextLine();
    System.out.println("Kérem a 4. telefon memóriájának méretét:");
    int phoneMem4 = scanner.nextInt();
    scanner.nextLine();

    Phone phone3 = new Phone(phoneType3, phoneMem3);
    Phone phone4 = new Phone(phoneType4, phoneMem4);

    System.out.println(phone1.getType());
    System.out.println(phone1.getMem());
    System.out.println(phone2.getType());
    System.out.println(phone2.getMem());

    System.out.println(phone3.getType());
    System.out.println(phone3.getMem());
    System.out.println(phone4.getType());
    System.out.println(phone4.getMem());


  }
}