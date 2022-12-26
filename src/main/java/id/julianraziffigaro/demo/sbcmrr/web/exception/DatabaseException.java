package id.julianraziffigaro.demo.sbcmrr.web.exception;

import java.io.Serial;

public class DatabaseException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = -7894039018154076953L;

  public DatabaseException(String message) {
    super(message);
  }

  public DatabaseException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
