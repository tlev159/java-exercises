package week13d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherFinderTest {

  TeacherFinder tf = new TeacherFinder();

  @Test
  void fillTeachersPlan() {
    tf.fillTeachersPlan("beosztas.txt");

    assertEquals("Antilop Anett", tf.getTeachersPlans().get(3).getName());
    assertEquals("tortenelem", tf.getTeachersPlans().get(5).getSubject());
    assertEquals("9.a", tf.getTeachersPlans().get(10).getClassName());

  }

  @Test
  void findClassNumberOfTeacher() {
    tf.fillTeachersPlan("beosztas.txt");
    assertEquals(22, tf.findClassNumberOfTeacher("Csincsilla Csilla"));

  }
}