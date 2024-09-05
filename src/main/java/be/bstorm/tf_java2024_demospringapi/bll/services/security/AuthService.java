package be.bstorm.tf_java2024_demospringapi.bll.services.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import be.bstorm.tf_java2024_demospringapi.dl.entities.User;

public interface AuthService extends UserDetailsService {

    User register(User user);
    User login(String username, String password);
}
