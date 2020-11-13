package classstructuremethods;

public class NoteMain {

  public static void main(String[] args) {
    Note note = new Note();

    note.setName("John Doe");
    note.setTopic("Valami");
    note.setText("Hát nem gondoltam volna, hogy így fog sikerülni!");

    System.out.println(note.getNoteText());
  }
}
