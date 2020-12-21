package inheritanceconstructor.classroom;

public class ClassRoom extends Room {
  private Facility facility;


  public ClassRoom(String location, int capacity, Facility facility) {
    super(location, capacity);
    this.facility = facility;
  }

  public boolean isSuitable(Course course) {
//    Course course1 = new Course(getCapacity(), getFacility());
//    if (course.getParticipants() <= course1.getParticipants() && course.getFacilityNeeded() == course1.getFacilityNeeded()) {
//      return true;
//    } else {
//      return  false;
//    }
    return course.getParticipants() <= getCapacity() && course.getFacilityNeeded() == getFacility();
  }

  public Facility getFacility() {
    return facility;
  }
}
