package introconstructors;

public class TaskMain {

  public static void main(String[] args) {
    Task task = new Task("Kutyaséta", "El kell vinni a kutyát sétálni");

    System.out.println(task.getTitle());
    System.out.println(task.getDescription());

    task.start();
    task.setDuration(180);
    System.out.println(task.getStartDateTime());
  }

}
