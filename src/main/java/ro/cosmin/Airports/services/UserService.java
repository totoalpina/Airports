package ro.cosmin.Airports.services;


import ro.cosmin.Airports.domain.User;
import ro.cosmin.Airports.models.UserDto;

import java.util.Optional;

public interface UserService {

    Optional<UserDto> findById(Long id);

    Optional<UserDto> findByEmail(String email);

    User save(UserDto userDto);

}
