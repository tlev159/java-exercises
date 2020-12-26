package interfacedefaultmethods.print;

public class ColoredPage {

  private String pageText;
  private String pageColor;

  public ColoredPage(String pageText, String pageColor) {
    this.pageText = pageText;
    this.pageColor = pageColor;
  }

  public ColoredPage(String pageText) {
    new ColoredPage(pageText, Printable.BLACK);
  }

  public String getPageText() {
    return pageText;
  }

  public String getPageColor() {
    return pageColor;
  }
}
