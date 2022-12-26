package id.julianraziffigaro.demo.sbcmrr.web.service;

import id.julianraziffigaro.demo.sbcmrr.cache.model.UserDetails;
import id.julianraziffigaro.demo.sbcmrr.web.domain.model.Action;
import id.julianraziffigaro.demo.sbcmrr.web.domain.model.UserDomain;

public interface UserService {

  UserDetails saveOrUpdate(Action action, UserDomain userDomain);
}
