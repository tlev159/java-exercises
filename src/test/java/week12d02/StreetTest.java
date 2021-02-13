package week12d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {

  @Test
  void houseNumberOfTheLastSelldHouse() {

    Street street = new Street();
    street.sellSite(new Site(0, 10, Fence.PERFECT));
    street.sellSite(new Site(0, 7, Fence.NEED_UPGRADE));
    street.sellSite(new Site(1, 12, Fence.NEED_UPGRADE));
    street.sellSite(new Site(0, 9, Fence.PERFECT));
    street.sellSite(new Site(0, 11, Fence.NO_FENCE));
    street.sellSite(new Site(1, 13, Fence.PERFECT));

    assertEquals(3, street.houseNumberOfTheLastSelldHouse());

    street.sellSite(new Site(0, 13, Fence.PERFECT));
    assertEquals(10, street.houseNumberOfTheLastSelldHouse());

  }

  @Test
  public void fenceStatTest() {

    Street street = new Street();
    street.sellSite(new Site(0, 10, Fence.PERFECT));
    street.sellSite(new Site(0, 7, Fence.NEED_UPGRADE));
    street.sellSite(new Site(1, 12, Fence.NEED_UPGRADE));
    street.sellSite(new Site(0, 9, Fence.PERFECT));
    street.sellSite(new Site(0, 11, Fence.NO_FENCE));
    street.sellSite(new Site(1, 13, Fence.PERFECT));
    street.sellSite(new Site(0, 13, Fence.PERFECT));

    assertEquals(4, street.statistic().getPerfect());

  }
}