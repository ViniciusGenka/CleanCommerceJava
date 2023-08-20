package com.genka.cleancommerce.infra.usecases.auth;

import com.genka.cleancommerce.application.exceptions.CredentialAlreadyInUseException;
import com.genka.cleancommerce.application.gateways.UserDatabaseGateway;
import com.genka.cleancommerce.application.usecases.auth.UserSignUp;
import com.genka.cleancommerce.application.usecases.auth.dtos.UserSignUpInput;
import com.genka.cleancommerce.domain.user.User;
import com.genka.cleancommerce.domain.user.dtos.UserDTO;
import com.genka.cleancommerce.domain.user.enums.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSignUpImpl implements UserSignUp {
    private final UserDatabaseGateway userDatabaseGateway;
    private final PasswordEncoder passwordEncoder;

    public UserSignUpImpl(PasswordEncoder passwordEncoder, UserDatabaseGateway userDatabaseGateway) {
        this.passwordEncoder = passwordEncoder;
        this.userDatabaseGateway = userDatabaseGateway;
    }

    public UserDTO execute(UserSignUpInput userSignUpInput) {
        this.userDatabaseGateway.findByEmail(userSignUpInput.email()).ifPresent(user -> {
            throw new CredentialAlreadyInUseException("Email already in use");
        });
        String encryptedPassword = this.passwordEncoder.encode(userSignUpInput.password());
        User user = new User(
                null,
                userSignUpInput.email(),
                encryptedPassword,
                Role.CUSTOMER,
                userSignUpInput.username()
        );
        User savedUser = this.userDatabaseGateway.save(user);
        return new UserDTO(savedUser);
    }
}
