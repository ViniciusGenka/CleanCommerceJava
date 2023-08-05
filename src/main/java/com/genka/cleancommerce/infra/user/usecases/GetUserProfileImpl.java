package com.genka.cleancommerce.infra.user.usecases;

import com.genka.cleancommerce.application.exceptions.EntityNotFoundException;
import com.genka.cleancommerce.application.user.gateways.UserDatabaseGateway;
import com.genka.cleancommerce.application.user.usecases.GetUserProfile;
import com.genka.cleancommerce.application.user.usecases.dtos.GetUserProfileInput;
import com.genka.cleancommerce.domain.user.User;
import com.genka.cleancommerce.domain.user.dtos.UserDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetUserProfileImpl implements GetUserProfile {
    private final UserDatabaseGateway userDatabaseGateway;

    public GetUserProfileImpl(UserDatabaseGateway userDatabaseGateway) {
        this.userDatabaseGateway = userDatabaseGateway;
    }

    public UserDTO execute(GetUserProfileInput getUserProfileInput) {
        User user = this.userDatabaseGateway.findById(getUserProfileInput.id())
                .orElseThrow(()-> new EntityNotFoundException("User not found"));
        return new UserDTO(user);
    }
}
