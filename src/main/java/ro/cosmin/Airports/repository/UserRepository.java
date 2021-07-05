package ro.cosmin.Airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cosmin.Airports.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
