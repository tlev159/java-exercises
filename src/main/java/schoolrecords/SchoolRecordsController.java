package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

  ClassRecords classRecords = new ClassRecords("9.A", new Random());
  List<Subject> subjects = new ArrayList<>();
  List<Tutor> tutors = new ArrayList<>();

  public static void main(String[] args) {
    SchoolRecordsController sRC = new SchoolRecordsController();
    sRC.initSchool();
    Scanner scanner = new Scanner(System.in);
    int menuNumber = 0;
    while (menuNumber != 11) {
//      System.out.println(System.lineSeparator().repeat(50));
      sRC.printMenu();
      System.out.println("Kérem válasszon a menüpontok közül számuk alapján!");
      menuNumber = Integer.parseInt(scanner.nextLine());
      sRC.whitchMenu(menuNumber);
    }
//    System.out.println(sRC.classRecords.listStudentNames());
  }

  public void whitchMenu(int number) {
    switch (number) {
      case 1:
        menuOne();break;
      case 2:
        menuTwo(); break;
      case 3:
        menuThree(); break;
      case 4:
        menuFour(); break;
      case 5:
        menuFive(); break;
      case 6:
        menuSix(); break;
      case 7:
        menuSeven(); break;
      case 8:
        menuEigth(); break;
      case 9:
        menuNine(); break;
      case 10:
        menuTen(); break;
      case 11:
        System.out.println("További szép napot kívánok! Kiléptem...");
        break;
      default:
        System.out.println("Ilyen menüpont nincs, kérem válasszon újra!");
    }
  }

  public void menuOne() {
    System.out.println("Az osztály tanulóinak neve:");
    System.out.println(classRecords.listStudentNames());
    System.out.println();
  }

  public void menuTwo() {
    System.out.println("Kérem adja meg a keresett diák nevét!");
    Scanner scanner = new Scanner(System.in);
    System.out.println(classRecords.findStudentByName(scanner.nextLine()));
    System.out.println();
  }

  public void menuThree() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kérem a hozzáadni kívánt diák nevét!");
    classRecords.addStudent(new Student(scanner.nextLine()));
    System.out.println();
  }

  public void menuFour() { // diák név alapján törlése
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kérem a törölni kívánt diák nevét!");
    Student studentToRemove = classRecords.findStudentByName(scanner.nextLine());
    classRecords.removeStudent(studentToRemove);
//    classRecords.removeStudent(new Student(scanner.nextLine()));
  }

  public void menuFive() { //diák feleltetése
    Scanner scanner = new Scanner(System.in);
    String studentToRepetition = classRecords.repetition().getName();
    System.out.println("Kérem a felelő (" + studentToRepetition + ") érdemjegyét (A, B, C, D, F)");
    String studentMark = scanner.nextLine();
    System.out.println("Kérem a tantárgy nevét:");
    String studentSubject = scanner.nextLine();
    System.out.println("Kérem a tanár nevét:");
    String studentTutor = scanner.nextLine();
    System.out.println();
//    még nincs kész
  }

  public void menuSix() { //Osztályátlag kiszámolása
    System.out.println("Az osztály átlaga: " + classRecords.calculateClassAverage());
  }

  public void menuSeven() { // Tantárgyi átlag kiszámolása
    Scanner scanner = new Scanner(System.in);
    System.out.println("A tantárgyat, amely osztályátlagát kéred:");
    System.out.println(classRecords.calculateClassAverageBySubject(new Subject(scanner.nextLine())));
  }

  public void menuEigth() {
//    Scanner scanner = new Scanner(System.in);
    System.out.println("A diákok átlaga: ");
    for (int i = 0; i < classRecords.listStudyResults().size(); i++) {
      System.out.print(classRecords.listStudyResults().get(i).getStudentName() + " átlaga: ");
      System.out.println(classRecords.listStudyResults().get(i).getStudyAverage());
      System.out.println();
    }
  }

  public void menuNine() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kérem a diák nevét, akinek az átlagát le szeretné kérdezni!");
    Student searchedStudent = classRecords.findStudentByName(scanner.nextLine());
    System.out.println(searchedStudent.getName() + " tanulmányi átlaga: " + searchedStudent.calculateAverage());
  }

  public void menuTen() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kérem a diák nevét!");
    Student student = classRecords.findStudentByName(scanner.nextLine());
    System.out.println("Kérem a tantárgy nevét!");
    String searchedSubject = scanner.nextLine();
    Subject searchForSubject = new Subject(searchedSubject);
    System.out.println(student.getName() + " átlaga " + searchForSubject.getSubjectName()
            + " tantárgyból: " + student.calculateSubjectAverage(searchForSubject));
    
  }

  public void printMenu() {
    System.out.println("1. Diákok nevének listázása");
    System.out.println("2. Diák név alapján keresése");
    System.out.println("3. Diák létrehozása");
    System.out.println("4. Diák név lapján törlése");
    System.out.println("5. Diák feleltetése");
    System.out.println("6. Osztályátlag kiszámolása");
    System.out.println("7. Tantárgyi átlag kiszámolása");
    System.out.println("8. Diákok átlagának megjelenítése");
    System.out.println("9. Diák átlagának kiírása");
    System.out.println("10. Diák tantárgyhoz tartozó átlagának kiírása");
    System.out.println("11. Kilépés");
  }

  public void initSchool() {
    Tutor tutor = new Tutor("Nagy Csilla",
            Arrays.asList(new Subject("földrajz"),
                    new Subject("matematika"),
                    new Subject("biológia")));

    Tutor tutor1 = new Tutor("Kis Ágota",
            Arrays.asList(new Subject("zene"),
                    new Subject("fizika"),
                    new Subject("kémia")));

    Tutor tutor2 = new Tutor("Közepes Ármin",
            Arrays.asList(new Subject("testnevelés"),
                    new Subject("informatika"),
                    new Subject("német")));

    Student firstStudent = new Student("Kovács Rita");
    Student secondStudent = new Student("Nagy Béla");
    Student thirdStudent = new Student("Varga Márton");
    firstStudent.grading(new Mark(MarkType.A, new Subject("földrajz"), tutor));
    firstStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
    firstStudent.grading(new Mark(MarkType.D, new Subject("földrajz"), tutor));
    firstStudent.grading(new Mark(MarkType.B, new Subject("német"), tutor));
    firstStudent.grading(new Mark(MarkType.A, new Subject("német"), tutor));
    secondStudent.grading(new Mark(MarkType.A, new Subject("biológia"), tutor));
    secondStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
    secondStudent.grading(new Mark(MarkType.C, new Subject("testnevelés"), tutor));
    secondStudent.grading(new Mark(MarkType.D, new Subject("zene"), tutor));
    thirdStudent.grading(new Mark(MarkType.A, new Subject("fizika"), tutor));
    thirdStudent.grading(new Mark(MarkType.C, new Subject("kémia"), tutor));
    thirdStudent.grading(new Mark(MarkType.D, new Subject("földrajz"), tutor));
    thirdStudent.grading(new Mark(MarkType.B, new Subject("informatika"), tutor));
    thirdStudent.grading(new Mark(MarkType.B, new Subject("matematika"), tutor));
    classRecords.addStudent(firstStudent);
    classRecords.addStudent(secondStudent);
    classRecords.addStudent(thirdStudent);

  }
}
