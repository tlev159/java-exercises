package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {

  public static final int NUMBER_OF_FIELDS = 3;
  public static final int IP_POSITION = 0;
  public static final int DATE_POSITION = 1;
  public static final int LOGIN_POSITION = 2;
  public static final String SEPARATOR = ":";
  public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");


  public Map<String, List<Entry>> parseLog(String log) {
    try (Scanner scanner = new Scanner(log)) {
      Map<String, List<Entry>> result = new HashMap<>();
      while (scanner.hasNext()) {
        String line = scanner.next();
        String[] splittedLog = line.split(SEPARATOR);
        if (splittedLog.length != NUMBER_OF_FIELDS) {
          throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
        }
        String ip = splittedLog[IP_POSITION];
        LocalDate date = stringToDate(splittedLog[DATE_POSITION]);
        String login = splittedLog[LOGIN_POSITION];
        Entry entry = new Entry(ip, date, login);
        System.out.println(entry.toString());
        if (!result.containsKey(entry.getIpAddress())) {
          result.put(entry.getIpAddress(), new ArrayList<>());
        }
        result.get(entry.getIpAddress()).add(entry);
      }
      return result;
    }
  }

  private LocalDate stringToDate(String str) {
    try {
      return LocalDate.parse(str, DATE_FORMAT);
    } catch (DateTimeParseException dtpe) {
      throw new IllegalArgumentException("Incorrect log: incorrect date", dtpe);
    }
  }


}
