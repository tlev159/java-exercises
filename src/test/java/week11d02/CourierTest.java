package week11d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

  @Test
  public void addFirstRideThrow() {

    Courier courier = new Courier();

    assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(0, 1, 12)));
    assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(8, 1, 12)));
    assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(2, 2, 12)));
  }

  @Test
  public void addFirstRide() {
    Courier cr1 = new Courier();

    cr1.addRide(new Ride(1, 1, 12));
    assertEquals(1, cr1.getRides().size());

    Courier cr2 = new Courier();
    cr2.addRide(new Ride(3, 1, 11));
    assertEquals(1, cr2.getRides().size());

    Courier cr3 = new Courier();
    cr3.addRide(new Ride(5, 1, 15));
    assertEquals(1, cr3.getRides().size());

  }

  @Test
  public void addRides() {
    Courier cr = new Courier();

    cr.addRide(new Ride(1, 1, 12));
    cr.addRide(new Ride(1, 2, 14));
    cr.addRide(new Ride(3, 1, 11));
    cr.addRide(new Ride(3, 2, 13));
    cr.addRide(new Ride(5, 1, 15));

    assertEquals(5, cr.getRides().size());
  }

  @Test
  public void testFirstFreeDay() {
    Courier cr = new Courier();

    cr.addRide(new Ride(1, 1, 12));
    cr.addRide(new Ride(1, 2, 14));
    cr.addRide(new Ride(2, 1, 14));
    cr.addRide(new Ride(3, 1, 11));
    cr.addRide(new Ride(3, 2, 11));
    cr.addRide(new Ride(3, 3, 13));
    cr.addRide(new Ride(5, 1, 15));
    cr.addRide(new Ride(5, 2, 15));
    cr.addRide(new Ride(5, 3, 15));

    assertEquals(4, cr.firstFreeDay());
  }

  @Test
  public void testNoFreeDay() {
    Courier cr = new Courier();

    cr.addRide(new Ride(1, 1, 12));
    cr.addRide(new Ride(2, 1, 14));
    cr.addRide(new Ride(3, 1, 11));
    cr.addRide(new Ride(4, 1, 11));
    cr.addRide(new Ride(5, 1, 15));
    cr.addRide(new Ride(6, 1, 15));
    cr.addRide(new Ride(7, 1, 15));

    assertEquals(-1, cr.firstFreeDay());
  }



}