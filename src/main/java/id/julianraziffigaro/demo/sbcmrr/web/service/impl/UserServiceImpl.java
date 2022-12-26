package id.julianraziffigaro.demo.sbcmrr.web.service.impl;

import id.julianraziffigaro.demo.sbcmrr.cache.model.UserDetails;
import id.julianraziffigaro.demo.sbcmrr.web.domain.model.Action;
import id.julianraziffigaro.demo.sbcmrr.web.domain.model.UserDomain;
import id.julianraziffigaro.demo.sbcmrr.web.exception.DatabaseException;
import id.julianraziffigaro.demo.sbcmrr.web.exception.EditException;
import id.julianraziffigaro.demo.sbcmrr.web.exception.RegisterException;
import id.julianraziffigaro.demo.sbcmrr.web.repository.impl.UserRepositoryImpl;
import id.julianraziffigaro.demo.sbcmrr.web.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepositoryImpl userRepository;

  public UserServiceImpl(UserRepositoryImpl userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails saveOrUpdate(Action action, UserDomain userDomain) {
    String username = userDomain.username();
    String password = userDomain.password();

    if (action == Action.getByName("ADD")) {
      try {
        return userRepository.save(new UserDomain(username, password));
      } catch (DatabaseException ex) {
        throw new RegisterException(ex.getMessage(), ex);
      }
    } else if (action == Action.getByName("EDIT")) {
      try {
        return userRepository.update(new UserDomain(username, password));
      } catch (DatabaseException ex) {
        throw new EditException(ex.getMessage(), ex);
      }
    } else {
      return null;
    }
  }
}
