package ro.cosmin.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cosmin.airports.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
