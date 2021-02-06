package collectionsqueue.job;

import java.util.Queue;

public class NoJobException extends Exception {

  private final String message;

  public NoJobException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
