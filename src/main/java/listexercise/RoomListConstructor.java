package listexercise;

import java.util.ArrayList;
import java.util.List;

public class RoomListConstructor {

  private List<RoomLists> rooms = new ArrayList<>();

  public void addRoom(RoomLists room) {
    rooms.add(room);
  }

  public void printRooms() {
    for (RoomLists room : rooms) {
      System.out.println(room);
    }
  }

  public void printRoomlength() {
    for (int i = 0; i < rooms.size(); i++) {
      System.out.println("A " + rooms.get(i).getName() + " szoba hossza: " + rooms.get(i).getLength());
    }
  }
}
