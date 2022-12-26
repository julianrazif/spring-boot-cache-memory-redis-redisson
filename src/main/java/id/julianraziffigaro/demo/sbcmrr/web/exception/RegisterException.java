package id.julianraziffigaro.demo.sbcmrr.web.exception;

import java.io.Serial;

public class RegisterException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = -2218017714959573672L;

  public RegisterException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
