package coronaproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitizensTest {

  @Test
  public void testFullName() {
    Citizens citizens = new Citizens("Jane Doe", 6100, 11, "em@il", "em@il", "123456788");
    assertEquals("Jane Doe", citizens.getFullName());
  }

  @Test
  public void testFullNameNullThrow() {

    assertThrows(IllegalArgumentException.class, () -> new Citizens(null, 6100, 11, "em@il", "em@il", "123456788"));
  }

  @Test
  public void testZip() {
    Citizens citizens = new Citizens("Jane Doe", 6100, 11, "em@il", "em@il", "123456788");

    assertEquals(6100, citizens.getZip());
  }

  @Test
  public void testZipThrow() {

    assertThrows(IllegalArgumentException.class, () -> new Citizens(null, 999, 11, "em@il", "em@il", "123456788"));
    assertThrows(IllegalArgumentException.class, () -> new Citizens(null, 10000, 11, "em@il", "em@il", "123456788"));

  }

  @Test
  public void testGetAge() {
    Citizens citizens = new Citizens("Jane Doe", 6100, 11, "em@il", "em@il", "123456788");

    assertEquals(11, citizens.getAge());
  }

  @Test
  public void testAgeMinMaxThrows() {

    assertThrows(IllegalArgumentException.class, () -> new Citizens(null, 6100, 10, "em@il", "em@il", "123456788"));
    assertThrows(IllegalArgumentException.class, () -> new Citizens(null, 6100, 150, "em@il", "em@il", "123456788"));

  }

  @Test
  public void testEmail() {
    Citizens citizens = new Citizens("Jane Doe", 6100, 11, "em@il", "em@il", "123456788");

    assertEquals("em@il", citizens.getEmail());

  }

  @Test
  public void testWrongEmailThrow() {

    assertThrows(IllegalArgumentException.class, () -> new Citizens(null, 6100, 11, "em@il", "em@l", "123456788"));
    assertThrows(IllegalArgumentException.class, () -> new Citizens(null, 6100, 11, "em@", "em@", "123456788"));
    assertThrows(IllegalArgumentException.class, () -> new Citizens(null, 6100, 11, "emil", "emil", "123456788"));

  }

  @Test
  public void testCorrectTaj() {

    Citizens citizens = new Citizens("Jane Doe", 6100, 11, "em@il", "em@il", "123456788");

    assertEquals("123456788", citizens.getTaj());
  }

  @Test
  public void testWrongTajNumber() {

    assertThrows(IllegalArgumentException.class, () -> new Citizens(null, 6100, 11, "em@il", "em@il", "123456789"));

  }
}