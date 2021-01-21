package meetingrooms;

import meetingrooms.MeetingRoom;

import java.util.ArrayList;
import java.util.List;

public class Office {

  private List<MeetingRoom> meetingRooms = new ArrayList<>();

  public void addMeetingRoom(MeetingRoom meetingRoom) {
    meetingRooms.add(meetingRoom);
  }

  public void printNames() {
    for (int i = 0; i < meetingRooms.size(); i++) {
      System.out.println("Név: " + meetingRooms.get(i).getName());
    }
  }

  public void printNamesReverse() {
    for (int i = meetingRooms.size() - 1; i >= 0; i--) {
      System.out.println((i + 1) + " . tárgyaló neve: " + meetingRooms.get(i).getName());
    }
  }

  public void printEvenNames() {
    for (int i = 0; i < meetingRooms.size(); i++) {
      if (i % 2 == 0) {
      } else {
        System.out.println("Név: " + meetingRooms.get(i).getName());
      }
    }
  }

  public void printAreas() {
    for (int i = 0; i < meetingRooms.size(); i++) {
      System.out.println("A(z) " + meetingRooms.get(i).getName() + " nevű tárgyaló mérete: ");
      System.out.println(meetingRooms.get(i).getArea() + " négyzetméter.");
    }
  }

  public void printMeetingRoomsWithName(String searchedName) {
    for (int i = 0; i < meetingRooms.size(); i++) {
      if (meetingRooms.get(i).getName().equals(searchedName)) {
        System.out.println("A(z) " + searchedName + " nevű tárgyaló adatai:");
        System.out.println("Hosszúsága: " + meetingRooms.get(i).getLength() + " méter");
        System.out.println("Szélessége: " + meetingRooms.get(i).getWidth() + " méter");
        System.out.println("Területe: " + meetingRooms.get(i).getArea() + " négyzetméter.");
      }
    }
  }

  public void printMeetingRoomsContains(String partName) {
    String partNameUpperedName = partName.toUpperCase();
    for (int i = 0; i < meetingRooms.size(); i++) {
      String roomNameUppered = meetingRooms.get(i).getName().toUpperCase();
      if (roomNameUppered.contains(partNameUpperedName)) {
        System.out.println("A(z) " + meetingRooms.get(i).getName() + " nevű tárgyaló adatai:");
        System.out.println("Hosszúsága: " + meetingRooms.get(i).getLength() + " méter");
        System.out.println("Szélessége: " + meetingRooms.get(i).getWidth() + " méter");
        System.out.println("Területe: " + meetingRooms.get(i).getArea() + " négyzetméter.");
//        break;
      }
    }
  }
  public void printAreasLarger(int searchedMinArea) {
    System.out.println("A keresettnél nagyobb területű tárgyalók adatai:");
    for (int i = 0; i < meetingRooms.size(); i++) {
      int roomArea = meetingRooms.get(i).getArea();
      if (roomArea > searchedMinArea) {
        System.out.println("A(z) " + meetingRooms.get(i).getName() + " nevű tárgyaló adatai:");
        System.out.println("Hosszúsága: " + meetingRooms.get(i).getLength() + " méter");
        System.out.println("Szélessége: " + meetingRooms.get(i).getWidth() + " méter");
        System.out.println("Területe: " + meetingRooms.get(i).getArea() + " négyzetméter.");
      }
    }
  }

}
