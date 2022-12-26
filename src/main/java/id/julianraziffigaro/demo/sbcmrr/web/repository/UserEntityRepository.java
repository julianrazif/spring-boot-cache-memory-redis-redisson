package id.julianraziffigaro.demo.sbcmrr.web.repository;

import id.julianraziffigaro.demo.sbcmrr.web.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

  UserEntity findFirstByUsername(String username);
}
