package ro.cosmin.airports.services;


import ro.cosmin.airports.domain.User;
import ro.cosmin.airports.models.UserDto;

import java.util.Optional;

public interface UserService {

    Optional<UserDto> findById(Long id);

    Optional<UserDto> findByEmail(String email);

    User save(UserDto userDto);

}
