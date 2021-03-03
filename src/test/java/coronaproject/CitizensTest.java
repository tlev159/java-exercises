package coronaproject;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CitizensTest {

  @Test
  public void testFullName() {
    Citizens citizens = new Citizens("Jane Doe", 6100, 11, "em@il","123456788");
    assertEquals("Jane Doe", citizens.getFullName());
  }

  @Test
  public void testFullNameNullWrong() {

    Citizens citizen = new Citizens(null, 6100, 11, "em@il","123456788");

    assertEquals(null, citizen.getFullName());
    assertEquals(null, citizen.getEmail());
    assertEquals(null, citizen.getTaj());
  }

  @Test
  public void testZip() {
    Citizens citizen = new Citizens("Jane Doe", 6100, 11, "em@il","123456788");

    assertEquals(6100, citizen.getZip());
    assertEquals("em@il", citizen.getEmail());
  }

  @Test
  public void testZipThrow() {

    Citizens citizen = new Citizens("Jane Doe", 999, 11, "em@il","123456788");
    assertEquals(0L, citizen.getZip());
    assertEquals(null, citizen.getEmail());

  }

  @Test
  public void testGetAge() {
    Citizens citizens = new Citizens("Jane Doe", 6100, 11, "em@il","123456788");

    assertEquals(11, citizens.getAge());
  }

  @Test
  public void testAgeMinMaxThrows() {

    Citizens citizen1 = new Citizens("Jane Doe", 6100, 10, "em@il","123456788");
    assertEquals(0L, citizen1.getAge());
    assertEquals(null, citizen1.getEmail());

    Citizens citizen2 = new Citizens("Jane Doe", 6100, 150, "em@il","123456788");
    assertEquals(0L, citizen1.getAge());
    assertEquals(null, citizen1.getEmail());
  }

  @Test
  public void testEmail() {
    Citizens citizens = new Citizens("Jane Doe", 6100, 11, "em@il", "123456788");

    assertEquals("em@il", citizens.getEmail());

  }

  @Test
  public void testWrongEmailThrow() {

    Citizens citizen1 = new Citizens(1,"Jane Doe", 6100, 11, "email", "123456788", 0, LocalDate.now());
    assertEquals(null, citizen1.getEmail());

    Citizens citizen2 =  new Citizens("Jane Doe", 6100, 11, "em@", "123456788");
    assertEquals(null, citizen1.getEmail());

    Citizens citizen3 = new Citizens("Jane Doe", 6100, 11, "emil", "123456788");
    assertEquals(null, citizen1.getEmail());

    assertEquals(null, citizen1.getEmail());
    assertEquals(null, citizen1.getEmail());

  }

  @Test
  public void testCorrectTaj() {

    Citizens citizen = new Citizens("Jane Doe", 6100, 11, "em@il", "123456788");

    assertEquals("123456788", citizen.getTaj());
    assertEquals("em@il", citizen.getEmail());
  }

  @Test
  public void testWrongTajNumber() {

    Citizens citizen = new Citizens("Jane Doe", 6100, 11, "em@il", "123456789");
    assertEquals(null, citizen.getEmail());
    assertEquals(0L, citizen.getZip());

  }
}