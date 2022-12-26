package id.julianraziffigaro.demo.sbcmrr.web.repository;

import id.julianraziffigaro.demo.sbcmrr.cache.model.UserDetails;
import id.julianraziffigaro.demo.sbcmrr.web.domain.model.UserDomain;

public interface UserRepository {

  UserDetails save(UserDomain userDomain);
}
