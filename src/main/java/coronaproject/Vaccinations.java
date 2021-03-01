package coronaproject;

import java.time.LocalDateTime;

public class Vaccinations {

  private long vaccinationId;
  private long citizenId;
  private LocalDateTime date;
  private String status;
  private String note;
  private VaccinType vaccinType;

  public Vaccinations(LocalDateTime date, String status, String note, VaccinType vaccinType) {
    this.date = date;
    this.status = status;
    this.note = note;
    this.vaccinType = vaccinType;
  }

  public long getVaccinationId() {
    return vaccinationId;
  }

  public long getCitizenId() {
    return citizenId;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public String getStatus() {
    return status;
  }

  public String getNote() {
    return note;
  }

  public VaccinType getVaccinType() {
    return vaccinType;
  }

  public void setVaccinationId(long vaccinationId) {
    this.vaccinationId = vaccinationId;
  }

  public void setCitizenId(long citizenId) {
    this.citizenId = citizenId;
  }

  @Override
  public String toString() {
    return "Vaccinations{" +
            "vaccinationId=" + vaccinationId +
            ", citizenId=" + citizenId +
            ", date=" + date +
            ", status='" + status + '\'' +
            ", note='" + note + '\'' +
            ", vaccinType=" + vaccinType +
            '}';
  }
}
