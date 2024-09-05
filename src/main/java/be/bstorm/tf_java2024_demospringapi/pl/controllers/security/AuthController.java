package be.bstorm.tf_java2024_demospringapi.pl.controllers.security;

import be.bstorm.tf_java2024_demospringapi.bll.services.security.AuthService;
import be.bstorm.tf_java2024_demospringapi.dl.entities.User;
import be.bstorm.tf_java2024_demospringapi.il.utils.JwtUtils;
import be.bstorm.tf_java2024_demospringapi.pl.models.user.UserLoginForm;
import be.bstorm.tf_java2024_demospringapi.pl.models.user.UserRegisterForm;
import be.bstorm.tf_java2024_demospringapi.pl.models.user.UserTokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<UserTokenDTO> register(@RequestBody UserRegisterForm form) {
        User u = authService.register(form.toEntity());
        return ResponseEntity.ok(mapUserToken(u));
    }

    @PostMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<UserTokenDTO> login(@RequestBody UserLoginForm form) {
        User u = authService.login(form.username(), form.password());
        return ResponseEntity.ok(mapUserToken(u));
    }

    private UserTokenDTO mapUserToken(User u) {

        String token = jwtUtils.generateToken(u);
        return UserTokenDTO.fromEntity(u,token);
    }
}
