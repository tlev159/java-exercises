package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

  private List<CatalogItem> catalogItems = new ArrayList<>();

  public void addItem(CatalogItem item) {

  }

  public double averagePageNumberOver(int number) {
    return 0.0;
  }

  public void deleteItemByRegistrationNumber(String regNumber) {

  }

  public List<CatalogItem> findByCriteria(SearchCriteria criteria) {
    return new ArrayList<>();
  }

  public int getAllPageNumber() {
    return 0;
  }

  public List<CatalogItem> getAudioLibraryItems() {
    return new ArrayList<>();
  }

  public int getFullLength() {
    return 0;
  }

  public List<CatalogItem> getPrintedLibraryItems() {
    return new ArrayList<>();
  }

}
