package exceptionclass.bank2;

import exceptionclass.bank.ErrorCode;

public class InvalidBankOperationException extends RuntimeException {

  private String message;

  public InvalidBankOperationException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
