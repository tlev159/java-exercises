package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TeacherFinder {

  private static final String SEPARATOR = FileSystems.getDefault().getSeparator();

  private List<TeachersPlan> teachersPlans = new ArrayList<>();

  public void fillTeachersPlan(String pathName) {
    String path = "src" + SEPARATOR + "main" + SEPARATOR + "resources" + SEPARATOR + "week13d03" + SEPARATOR + pathName;
    Path file = Path.of(path);
    try (BufferedReader reader = Files.newBufferedReader(file)) {

      String[] block = new String[4];
      while ((block[0] = reader.readLine()) != null) {
        teachersPlans.add(processBlock(reader, block));
      }
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file!", ioe);
    }
  }

  private TeachersPlan processBlock(BufferedReader br, String[] block) throws IOException {
    for (int i = 1; i < 4; i++) {
      block[i] = br.readLine();
    }
    return new TeachersPlan(block[0], block[1], block[2], Integer.parseInt(block[3]));
  }

  public int findClassNumberOfTeacher(String teacher) {
    int result = 0;
    for (TeachersPlan teachersPlan:teachersPlans) {
      if (teachersPlan.getName().equals(teacher)) {
        result += teachersPlan.getHoursPerWeek();
      }
    }
    return result;
  }

  public List<TeachersPlan> getTeachersPlans() {
    return teachersPlans;
  }
}
