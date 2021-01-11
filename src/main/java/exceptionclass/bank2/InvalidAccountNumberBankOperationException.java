package exceptionclass.bank2;

public class InvalidAccountNumberBankOperationException extends InvalidBankOperationException {


  public InvalidAccountNumberBankOperationException(String message) {
    super(message);
  }

  @Override
  public String getMessage() {
    return "Invalid account number";
  }
}
