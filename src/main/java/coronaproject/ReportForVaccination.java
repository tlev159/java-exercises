package coronaproject;

public class ReportForVaccination {

  private int zip;
  private int numberOfVaccination;

  public ReportForVaccination(int zip, int numberOfVaccination) {
    this.zip = zip;
    this.numberOfVaccination = numberOfVaccination;
  }

  public int getZip() {
    return zip;
  }

  public int getNumberOfVaccination() {
    return numberOfVaccination;
  }

  @Override
  public String toString() {
    return "ReportForVaccination{" +
            "zip=" + zip +
            ", numberOfVaccination=" + numberOfVaccination +
            '}';
  }
}
