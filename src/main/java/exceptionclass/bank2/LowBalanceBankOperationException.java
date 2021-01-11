package exceptionclass.bank2;

public class LowBalanceBankOperationException extends InvalidBankOperationException {


  public LowBalanceBankOperationException(String message) {
    super(message);
  }

  @Override
  public String getMessage() {
    return "Low balance";
  }
}
