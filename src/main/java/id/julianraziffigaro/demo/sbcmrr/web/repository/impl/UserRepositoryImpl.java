package id.julianraziffigaro.demo.sbcmrr.web.repository.impl;

import id.julianraziffigaro.demo.sbcmrr.cache.model.User;
import id.julianraziffigaro.demo.sbcmrr.cache.model.UserDetails;
import id.julianraziffigaro.demo.sbcmrr.web.domain.entity.UserEntity;
import id.julianraziffigaro.demo.sbcmrr.web.domain.model.UserDomain;
import id.julianraziffigaro.demo.sbcmrr.web.exception.DatabaseException;
import id.julianraziffigaro.demo.sbcmrr.web.repository.UserEntityRepository;
import id.julianraziffigaro.demo.sbcmrr.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

  private final UserEntityRepository userEntityRepository;

  @Override
  public UserDetails save(UserDomain userDomain) {
    String username = userDomain.username();

    var userEntity = findFirstByUsername(username);

    if (userEntity != null) {
      throw new DatabaseException(String.format("Duplicate username: %s", username));
    }

    String password = userDomain.password();

    userEntity = saveOrUpdate(null, username, password);

    return getUserDetails(userEntity);
  }

  public UserDetails update(UserDomain userDomain) {
    String username = userDomain.username();

    var userEntity = userEntityRepository.findFirstByUsername(username);

    if (userEntity == null) {
      throw new DatabaseException(String.format("Can not find user with username: %s", username));
    }

    Long userId = userEntity.getId();

    String password = userDomain.password();

    userEntity = saveOrUpdate(userId, username, password);

    return getUserDetails(userEntity);
  }

  private UserEntity findFirstByUsername(String username) {
    UserEntity userEntity;

    try {
      userEntity = userEntityRepository.findFirstByUsername(username);
    } catch (Exception ex) {
      throw new DatabaseException(
        String.format("Can not find the user in database with username: %s", username),
        ex
      );
    }

    return userEntity;
  }

  private UserEntity saveOrUpdate(Long id, String username, String password) {
    UserEntity userEntity;

    try {
      userEntity = userEntityRepository.save(new UserEntity(id, username, password));
    } catch (Exception ex) {
      throw new DatabaseException(
        String.format("Can not save or update the user to database with username: %s", username),
        ex
      );
    }

    return userEntity;
  }

  private static UserDetails getUserDetails(UserEntity userEntity) {
    return User.withUserDetails(
      new User(
        userEntity.getUsername(),
        userEntity.getPassword()
      )
    ).build();
  }
}
