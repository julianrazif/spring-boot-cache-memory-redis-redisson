package id.julianraziffigaro.demo.sbcmrr.cache.model;

import org.springframework.util.Assert;

import java.util.Objects;

public record User(String username, String password) implements UserDetails {

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    var user = (User) o;
    return username.equals(user.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username);
  }


  public static UserBuilder builder() {
    return new UserBuilder();
  }

  public static UserBuilder withUserDetails(UserDetails userDetails) {
    return withUsername(userDetails.username())
      .password(userDetails.password());
  }

  public static UserBuilder withUsername(String username) {
    return builder().username(username);
  }

  public static final class UserBuilder {

    private String username;

    private String password;

    private UserBuilder() {
    }

    public UserBuilder username(String username) {
      Assert.notNull(username, "username cannot be null");
      this.username = username;
      return this;
    }

    public UserBuilder password(String password) {
      Assert.notNull(password, "password cannot be null");
      this.password = password;
      return this;
    }

    public UserDetails build() {
      return new User(this.username, this.password);
    }
  }
}
