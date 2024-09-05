package be.bstorm.tf_java2024_demospringapi.dal;

import be.bstorm.tf_java2024_demospringapi.dal.repositories.ProductRepository;
import be.bstorm.tf_java2024_demospringapi.dal.repositories.UserRepository;
import be.bstorm.tf_java2024_demospringapi.dl.entities.Product;
import be.bstorm.tf_java2024_demospringapi.dl.entities.User;
import be.bstorm.tf_java2024_demospringapi.dl.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            List<Product> products = List.of(
                    new Product("billes",null,10D,100),
                    new Product("cartes",null,15D,50),
                    new Product("gogoss",null,5D,42),
                    new Product("puissance quattre",null,20D,20),
                    new Product("cluedo",null,15D,35)
            );
            productRepository.saveAll(products);
        }
        if(userRepository.count() == 0) {
            String password = passwordEncoder.encode("Test1234=");
            User admin = new User("Admin",password);
            admin.setRole(UserRole.ADMIN);
            userRepository.save(admin);

            User user = new User("User",password);
            user.setRole(UserRole.USER);
            userRepository.save(user);
        }
    }
}
