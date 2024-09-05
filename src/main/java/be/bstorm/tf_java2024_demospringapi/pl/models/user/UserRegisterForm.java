package be.bstorm.tf_java2024_demospringapi.pl.models.user;

import be.bstorm.tf_java2024_demospringapi.dl.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterForm(
        @NotBlank
        @Size(max = 50)
        String username,
        @NotBlank
        String password
) {
    public User toEntity() {
        return new User(username, password);
    }
}
