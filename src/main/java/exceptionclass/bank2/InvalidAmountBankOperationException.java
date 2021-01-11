package exceptionclass.bank2;

public class InvalidAmountBankOperationException extends InvalidBankOperationException {


  public InvalidAmountBankOperationException(String message) {
    super(message);
  }

  @Override
  public String getMessage() {
    return "Invalid amount";
  }
}
