package controlselection.week;

public class DayOfWeeks {

  public String whichDay(String day) {
    String dayLowerCase = day.toLowerCase();
    switch (dayLowerCase) {
      case "hétfő":
        return "hét eleje";
      case "kedd":
      case "szerda":
      case "csütörtök":
        return "hét közepe";
      case "péntek":
        return "majdnem hétvége";
      case "szombat":
      case "vasárnap":
        return "hét vége";
      default:
        throw new IllegalArgumentException("Invalid day: " + day);
    }

  }
}
