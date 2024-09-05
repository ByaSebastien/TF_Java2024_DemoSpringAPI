package be.bstorm.tf_java2024_demospringapi.pl.models.user;

import be.bstorm.tf_java2024_demospringapi.dl.entities.User;
import be.bstorm.tf_java2024_demospringapi.dl.enums.UserRole;

public record UserTokenDTO(
        Long id,
        String username,
        UserRole role,
        String token
) {

    public static UserTokenDTO fromEntity(User user,String token) {
        return new UserTokenDTO(user.getId(),user.getUsername(),user.getRole(),token);
    }
}
