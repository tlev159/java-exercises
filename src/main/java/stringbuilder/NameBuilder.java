package stringbuilder;

public class NameBuilder {

  private String familyName;
  private String middleName;
  private String givenName;
  private Title title;


//  public NameBuilder(String familyName, String middleName, String givenName) {
//    if (isEmpty(familyName) || isEmpty(givenName)) {
//      this.familyName = familyName;
//      this.givenName = givenName;
//    } else {
//      throw new IllegalArgumentException("Family name an given name must be not empty!");
//    }
//    this.middleName = middleName;
//  }


  public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
    StringBuilder fullName;
    if (isEmpty(familyName) || isEmpty(givenName)) {
      throw new IllegalArgumentException("Family name and given name must not be empty!");
    }
    if (isEmpty(middleName) && isEmpty(title.getTitle())) {
      fullName = new StringBuilder(familyName.concat(" ").concat(givenName));
    } else if (title == null || isEmpty(title.getTitle())){
      fullName = new StringBuilder(familyName.concat(" ").concat(middleName).concat(" ").concat(givenName));
    } else if (isEmpty(middleName)){
      fullName = new StringBuilder(title.getTitle().concat(" ").concat(familyName).concat(" ").concat(givenName));
    } else {
      fullName = new StringBuilder(title.getTitle().concat(" ").concat(familyName).concat(" ").concat(middleName).concat(" ").concat(givenName));
    }
    return fullName.toString();
  }

  public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
    StringBuilder fullName;
    if (isEmpty(familyName) || isEmpty(givenName)) {
      throw new IllegalArgumentException("Family name and given name must not be empty!");
    }
    if (isEmpty(middleName) && isEmpty(title.getTitle())) {
      fullName = new StringBuilder(givenName.concat(" ").concat(familyName));
    } else if (title == null || isEmpty(title.getTitle())){
      fullName = new StringBuilder(givenName.concat(" ").concat(middleName).concat(" ").concat(familyName));
    } else if (isEmpty(middleName)){
      fullName = new StringBuilder(title.getTitle().concat(" ").concat(givenName).concat(" ").concat(familyName));
    } else {
      fullName = new StringBuilder(title.getTitle().concat(" ").concat(givenName).concat(" ").concat(middleName).concat(" ").concat(familyName));
    }
    return fullName.toString();
  }

  public String insertTitle(String name, Title title, String str) {
    StringBuilder modifiedName = new StringBuilder().append(name).insert(name.indexOf(" "), str.concat(title.getTitle()));
    return modifiedName.toString();
  }

  public String deleteNamePart(String name, String toDeletePart) {
    int startIndex = name.indexOf(toDeletePart);
    int endIndex = startIndex + toDeletePart.length();
    StringBuilder modifiedName = new StringBuilder().append(name).delete(startIndex, endIndex);
    return modifiedName.toString();
  }

  private boolean isEmpty(String str) {
    return str == null || str.trim().isBlank();
  }
}
