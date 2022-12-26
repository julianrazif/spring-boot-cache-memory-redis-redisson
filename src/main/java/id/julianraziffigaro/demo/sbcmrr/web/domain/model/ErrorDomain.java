package id.julianraziffigaro.demo.sbcmrr.web.domain.model;

import java.io.Serial;

public record ErrorDomain(Integer errorCode, String message) implements BaseDomain {

  @Serial
  private static final long serialVersionUID = -5320168670067301708L;
}
