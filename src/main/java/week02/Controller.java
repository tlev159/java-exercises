package week02;

import java.util.Scanner;

public class Controller {

  Office office = new Office();

  Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    Controller controller = new Controller();

    controller.readOffice();

    controller.printMenu();

    controller.runMenu();
  }

  public void readOffice() {


    System.out.println("Hány db tárgyalót szeretnél rögzíteni?");
    int numberOfMeetingRooms = scanner.nextInt();
    scanner.nextLine();

    MeetingRoom[] meetingRoom = new MeetingRoom[numberOfMeetingRooms];

    for (int i = 0; i < numberOfMeetingRooms; i++) {
      System.out.println("Kérem a(z) " + (i+1) + ". nevét:");
      String name = scanner.nextLine();

      System.out.println("Kérem a szélességét (méterben):");
      int length = scanner.nextInt();

      System.out.println("Kérem a hosszúságát (méterben):");
      int width = scanner.nextInt();
      scanner.nextLine();
      meetingRoom[i] = new MeetingRoom(name, length, width);
      office.addMeetingRoom(meetingRoom[i]);
    }

  }

  public void printMenu() {

    System.out.println("1. Tárgyalók sorrendben");
    System.out.println("2. Tárgyalók visszafele sorrendben");
    System.out.println("3. Minden második tárgyaló");
    System.out.println("4. Területek");
    System.out.println("5. Keresés pontos név alapján");
    System.out.println("6. Keresés névtöredék alapján");
    System.out.println("7. Keresés terület alapján");

  }

  public void runMenu() {
    System.out.println("Kérem a végrehajtanó feladat sorszámát!");
    int menuNumber = scanner.nextInt();
    scanner.nextLine();
    switch (menuNumber) {
      case 1:
        System.out.println("Az 1-est választotta:");
        office.printNames();
        break;
      case 2:
        System.out.println("A 2-es menüpontot választotta:");
        office.printNamesReverse();
        break;
      case 3:
        System.out.println("A 3-as menüpontot választotta:");
        office.printEvenNames();
        break;
      case 4:
        System.out.println("A 4-es menüpontot választotta:");
        office.printAreas();
        break;
      case 5:
        System.out.println("A 5-ös menüpontot választotta:");
        System.out.println("Kérem adja meg annak a tárgyalónak a nevét, mely adatait szeretné lekérni:");
        String searchedName = scanner.nextLine();
        office.printMeetingRoomsWithName(searchedName);
        break;
      case 6:
        System.out.println("A 6-os menüpontot választotta:");
        System.out.println("Kérem írja be, hogy milyen névtöredékre keressek rá:");
        String searchedPart = scanner.nextLine();
        office.printMeetingRoomsContains(searchedPart);
        break;
      case 7:
        System.out.println("A 7-es menüpontot választotta:");
        System.out.println("Kérem írja be, hogy minimum mekkora területű tárgyalókat keressek:");
        int searchedMinArea = scanner.nextInt();
        office.printAreasLarger(searchedMinArea);
        break;
    }
  }


}
