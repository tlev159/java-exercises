package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

  private String registrationNumber;
  private int price;
  private List<Feature> features = new ArrayList<>();

  public CatalogItem(String registrationNumber, int price, Feature features, Feature... features1) {
    this.registrationNumber = registrationNumber;
    this.price = price;
    this.features.add(features);
    for (Feature f:features1) {
      this.features.add(f);
    }
  }

  public int fullLengthAtOneItem() {
    int length = 0;
    for (int i = 0; i < features.size(); i++) {
      if (features.get(i) instanceof AudioFeatures) {
        AudioFeatures af = (AudioFeatures) features.get(i);
        length += af.getLength();
      }
    }
    return length;
  }

  public List<String> getContributors() {
    List<String> contribs = new ArrayList<>();
    for (int i = 0; i < features.size(); i++) {
      for (String f:features.get(i).getContributors()) {
        contribs.add(f);
      }
    }
    return contribs;
  }

  public List<String> getTitles() {
    List<String> titles = new ArrayList<>();
    for (Feature f:features) {
      titles.add(f.getTitle());
    }
    return titles;
  }

  public boolean hasAudioFeature() {
    boolean result = false;
    for (int i = 0; i < features.size(); i++) {
      if (features.get(i) instanceof AudioFeatures) {
        result = true;
      }
    }
    return result;
  }

  public boolean hasPrintedFeature() {
    boolean result = false;
    for (int i = 0; i < features.size(); i++) {
      if (features.get(i) instanceof PrintedFeatures) {
        result = true;
      }
    }
    return result;
  }

  public int numberOfPagesAtOneItem() {
    int pages = 0;
    for (int i = 0; i < features.size(); i++) {
      if (features.get(i) instanceof PrintedFeatures) {
        PrintedFeatures pf = (PrintedFeatures) features.get(i);
        pages += pf.getNumberOfPages();
      }
    }
    return pages;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public int getPrice() {
    return price;
  }

  public List<Feature> getFeatures() {
    return features;
  }
}
