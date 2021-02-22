package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

  private static final String SEPARATE = ":";
  private List<Mail> mails = new ArrayList<>();

  public void addMail(Mail mail) {
    mails.add(mail);
  }

  public List<Mail> getMails() {
    return mails;
  }

  public List<Mail> findByCriteria(String criteria) {
    List<Mail> result;
    String[] temp = criteria.split(SEPARATE);
    if (temp[0].equals("from")) {
      result = createListWithFrom(temp[1]);
    } else if (temp[0].equals("to")) {
      result = createListWithTo(temp[1]);
    } else {
      result = createListOther(criteria);
    }
    return result;
  }

  private List<Mail> createListWithFrom(String str) {
    List<Mail> temp = new ArrayList<>();
    for (Mail mail : mails) {
      if (mail.getFrom().getName().equals(str) || mail.getFrom().getEmail().equals(str)) {
        temp.add(mail);
      }
    }
    return temp;
  }

  private List<Mail> createListWithTo(String str) {
    List<Mail> temp = new ArrayList<>();
    for (Mail mail : mails) {
      isGivenStringContained(str, temp, mail);
    }
    return temp;
  }

  private void isGivenStringContained(String str, List<Mail> temp, Mail mail) {
    for (Contact contact: mail.getTo())
    if (contact.getName().equals(str) || contact.getEmail().equals(str)) {
      temp.add(mail);
    }
  }

  private List<Mail> createListOther(String str) {
    List<Mail> temp = new ArrayList<>();
    for (Mail mail : mails) {
      if (mail.getSubject().contains(str) || mail.getMessage().contains(str)) {
        temp.add(mail);
      }
    }
    return temp;
  }
}
