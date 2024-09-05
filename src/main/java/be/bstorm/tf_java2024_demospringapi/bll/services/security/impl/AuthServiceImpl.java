package be.bstorm.tf_java2024_demospringapi.bll.services.security.impl;

import be.bstorm.tf_java2024_demospringapi.bll.services.security.AuthService;
import be.bstorm.tf_java2024_demospringapi.dal.repositories.UserRepository;
import be.bstorm.tf_java2024_demospringapi.dl.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import be.bstorm.tf_java2024_demospringapi.dl.entities.User;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        if(userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User with username " + user.getUsername() + " already exists");
        }
        user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        User existingUser = userRepository.findByUsername(username).orElseThrow();
        if(!passwordEncoder.matches(password, existingUser.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }
        return existingUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow();
    }
}
