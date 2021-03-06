package ro.cosmin.airports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.cosmin.airports.entities.User;
import ro.cosmin.airports.enums.UserRole;
import ro.cosmin.airports.models.UserDto;
import ro.cosmin.airports.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<UserDto> findById(final Long id) {
        return userRepository.findById(id)
                .map(user -> new UserDto(user.getEmail(), user.getFirstName(), user.getLastName()));
    }

    @Override
    public Optional<UserDto> findByEmail(final String email) {
        return userRepository.findByEmail(email)
                .map(user -> new UserDto(user.getEmail(), user.getFirstName(), user.getLastName()));
    }

    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getFirstName(),
                userDto.getLastName(),
                UserRole.USER);
        return userRepository.save(user);
    }
}
