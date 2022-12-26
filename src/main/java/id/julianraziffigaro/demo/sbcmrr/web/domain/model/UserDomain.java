package id.julianraziffigaro.demo.sbcmrr.web.domain.model;

import java.io.Serial;

public record UserDomain(String username, String password) implements BaseDomain {

  @Serial
  private static final long serialVersionUID = -5324708375648684929L;
}
