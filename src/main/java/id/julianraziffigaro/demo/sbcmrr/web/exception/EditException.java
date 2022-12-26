package id.julianraziffigaro.demo.sbcmrr.web.exception;

import java.io.Serial;

public class EditException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 8988058834795630100L;

  public EditException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
