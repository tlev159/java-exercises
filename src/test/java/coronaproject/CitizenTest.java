package coronaproject;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CitizenTest {

  @Test
  public void testFullName() {
    Citizen citizen = new Citizen("Jane Doe", 6100, 11, "em@il","123456788");
    assertEquals("Jane Doe", citizen.getFullName());
  }

  @Test
  public void testFullNameNullWrong() {

    Citizen citizen = new Citizen(null, 6100, 11, "em@il","123456788");

    assertEquals(null, citizen.getFullName());
    assertEquals(null, citizen.getEmail());
    assertEquals(null, citizen.getTaj());
  }

  @Test
  public void testZip() {
    Citizen citizen = new Citizen("Jane Doe", 6100, 11, "em@il","123456788");

    assertEquals(6100, citizen.getZip());
    assertEquals("em@il", citizen.getEmail());
  }

  @Test
  public void testZipThrow() {

    Citizen citizen = new Citizen("Jane Doe", 999, 11, "em@il","123456788");
    assertEquals(0L, citizen.getZip());
    assertEquals(null, citizen.getEmail());

  }

  @Test
  public void testGetAge() {
    Citizen citizen = new Citizen("Jane Doe", 6100, 11, "em@il","123456788");

    assertEquals(11, citizen.getAge());
  }

  @Test
  public void testAgeMinMaxThrows() {

    Citizen citizen1 = new Citizen("Jane Doe", 6100, 10, "em@il","123456788");
    assertEquals(0L, citizen1.getAge());
    assertEquals(null, citizen1.getEmail());

    Citizen citizen2 = new Citizen("Jane Doe", 6100, 150, "em@il","123456788");
    assertEquals(0L, citizen1.getAge());
    assertEquals(null, citizen1.getEmail());
  }

  @Test
  public void testEmail() {
    Citizen citizen = new Citizen("Jane Doe", 6100, 11, "em@il", "123456788");

    assertEquals("em@il", citizen.getEmail());

  }

  @Test
  public void testWrongEmailThrow() {

    Citizen citizen1 = new Citizen(1,"Jane Doe", 6100, 11, "email", "123456788", 0, LocalDate.now());
    assertEquals(null, citizen1.getEmail());

    Citizen citizen2 =  new Citizen("Jane Doe", 6100, 11, "em@", "123456788");
    assertEquals(null, citizen1.getEmail());

    Citizen citizen3 = new Citizen("Jane Doe", 6100, 11, "emil", "123456788");
    assertEquals(null, citizen1.getEmail());

    assertEquals(null, citizen1.getEmail());
    assertEquals(null, citizen1.getEmail());

  }

  @Test
  public void testCorrectTaj() {

    Citizen citizen = new Citizen("Jane Doe", 6100, 11, "em@il", "123456788");

    assertEquals("123456788", citizen.getTaj());
    assertEquals("em@il", citizen.getEmail());
  }

  @Test
  public void testWrongTajNumber() {

    Citizen citizen = new Citizen("Jane Doe", 6100, 11, "em@il", "123456789");
    assertEquals(null, citizen.getEmail());
    assertEquals(0L, citizen.getZip());

  }
}