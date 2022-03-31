package kr.flab.ottsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.flab.ottsharing.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUserId(String userId);

    boolean existsByEmail(String email);

    User findByUserId(String userId);

    void deleteById(Integer id);
}
