package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

  List<CatalogItem> catalogItems = new ArrayList<>();

  public void addItem(CatalogItem item) {
    catalogItems.add(item);
  }

  public double averagePageNumberOver(int number) {
    if (number <= 0) {
      throw new IllegalArgumentException("Page number must be positive");
    }
    int numberOfPieces = 0;
    double pageNumbersOver = 0.0;
    for (CatalogItem ci:catalogItems) {
      if (ci.numberOfPagesAtOneItem() > number) {
        pageNumbersOver += ci.numberOfPagesAtOneItem();
        numberOfPieces++;
      }
    }
    if (numberOfPieces == 0) {
      throw new IllegalArgumentException("No page");
    }
    return pageNumbersOver / numberOfPieces;
  }

  public void deleteItemByRegistrationNumber(String regNumber) {
    for (int i = 0; i < catalogItems.size(); i++) {
      if (catalogItems.get(i).getRegistrationNumber().equals(regNumber)) {
        catalogItems.remove(i);
      }
    }
  }

  public List<CatalogItem> findByCriteria(SearchCriteria criteria) {
    List<CatalogItem> fbc = new ArrayList<>();
    for (int i = 0; i < catalogItems.size(); i++) {
//      System.out.println("gettitle: " + criteria.getTitle() + ", getcontri: " + criteria.getContributor());
      if (criteria.hasTitle() && criteria.hasContributor()) {
//        System.out.println("catalogitemget(i): " + catalogItems.get(i).getTitles());
//        System.out.println("catalogitemContrib(i): " + catalogItems.get(i).getContributors());
        if(catalogItems.get(i).getTitles().contains(criteria.title) && catalogItems.get(i).getContributors().toString().contains(criteria.contributor)) {
          fbc.add(catalogItems.get(i));
        }
      } else if (criteria.hasTitle()) {
        if (catalogItems.get(i).getTitles().contains(criteria.title)) {
          fbc.add(catalogItems.get(i));
        }
      } else if (criteria.hasContributor()) {
        if (catalogItems.get(i).getContributors().toString().contains(criteria.contributor)) {
          fbc.add(catalogItems.get(i));
        }
      }
    }
    return fbc;
  }

  public int getAllPageNumber() {
    int pageNumbers = 0;
    for (int i = 0; i < catalogItems.size(); i++) {
      pageNumbers += catalogItems.get(i).numberOfPagesAtOneItem();
      }
    return pageNumbers;
  }

  public List<CatalogItem> getAudioLibraryItems() {
    List<CatalogItem> ci = new ArrayList<>();
    for (int i = 0; i < catalogItems.size(); i++) {
      if (catalogItems.get(i).hasAudioFeature()) {
        ci.add(catalogItems.get(i));
      }
    }
    return ci;
  }

  public int getFullLength() {
    int fullLength = 0;
    for (int i = 0; i < catalogItems.size(); i++) {
      fullLength += catalogItems.get(i).fullLengthAtOneItem();
    }
    return fullLength;
  }

  public List<CatalogItem> getPrintedLibraryItems() {
    List<CatalogItem> ci = new ArrayList<>();
    for (int i = 0; i < catalogItems.size(); i++) {
      if (catalogItems.get(i).hasPrintedFeature()) {
        ci.add(catalogItems.get(i));
      }
    }
    return ci;
  }

}
